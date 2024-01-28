package com.example.integration.service;

import com.example.integration.config.JoltProperties;
import com.example.integration.utils.JoltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JoltService {

    @Autowired
    JoltUtils joltUtils;

    @Autowired
    JoltProperties joltProperties;

    public Mono<Object> joltTransform(String request) {

        return joltUtils.transform(request, joltProperties.getJoltSpec());
    }
}
