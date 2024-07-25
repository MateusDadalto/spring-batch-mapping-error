package com.example.batcherror.controllers;

import com.example.batcherror.model.Foo;
import com.example.batcherror.services.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

@Controller
public class FooController {

    private static final Logger log = LoggerFactory.getLogger(FooController.class);

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @MutationMapping
    public List<Foo> saveMany(@Argument List<String> input) {
        return input.stream().map(Foo::new).toList();
    }

    @QueryMapping
    public List<Foo> getMany() {
        return IntStream.range(0, 10).mapToObj(i -> new Foo(UUID.randomUUID().toString())).toList();
    }

    @BatchMapping(typeName = "Foo")
    public Map<Foo, String> bar(List<Foo> fooList) {
        log.info("I've been called with {}", fooList);
        return fooService.makeBar(fooList);
    }
}
