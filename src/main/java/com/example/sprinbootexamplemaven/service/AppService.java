package com.example.sprinbootexamplemaven.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class AppService {

    public List<String> searchForIdAndPaginate(String id, Integer skip, Integer top) {
        return Objects.equals(id, "0") ? List.of("result 1", "result 2") : Collections.emptyList();
    }
}
