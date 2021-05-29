package com.baaaki.posting.mockito.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String findSomething() {
        return "Actual method called";
    }
}
