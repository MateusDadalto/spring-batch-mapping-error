package com.example.batcherror.services;

import com.example.batcherror.model.Foo;

import java.util.List;
import java.util.Map;

public interface FooService {
    Map<Foo, String> makeBar(List<Foo> fooList);
}
