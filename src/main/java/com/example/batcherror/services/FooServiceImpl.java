package com.example.batcherror.services;

import com.example.batcherror.model.Foo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FooServiceImpl implements FooService {
    @Override
    public Map<Foo, String> makeBar(List<Foo> fooList) {
        return fooList.stream().collect(Collectors.toMap(f -> f, Foo::bar));
    }
}
