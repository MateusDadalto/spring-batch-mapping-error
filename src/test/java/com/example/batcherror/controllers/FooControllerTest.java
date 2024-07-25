package com.example.batcherror.controllers;

import com.example.batcherror.model.Foo;
import com.example.batcherror.services.FooService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@GraphQlTest(FooController.class)
class FooControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private FooService fooService;

    @Test
    void getManyQueryShouldCallFooServiceOnce() {
        // Arrange
        when(fooService.makeBar(anyList())).thenReturn(Map.of(new Foo("test"), "bar"));

        this.graphQlTester
                .document(
                """
                query {
                    getMany {
                        bar
                    }
                }
                """)
                .execute()
                .path("getMany");

        verify(fooService,times(1)).makeBar(anyList());
    }

    @Test
    void saveManyMutationShouldCallFooServiceOnce() {
        // Arrange
        when(fooService.makeBar(anyList())).thenReturn(Map.of(new Foo("test"), "bar"));

        this.graphQlTester
                .document(
                        """
                        mutation {
                            saveMany(input: ["a", "b", "c"]) {
                                bar
                            }
                        }
                        """)
                .execute()
                .path("getMany");

        verify(fooService,times(1)).makeBar(anyList());
    }

}