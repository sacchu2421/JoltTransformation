package com.example.integration.controller;

import com.example.integration.constants.JoltConstant;
import com.example.integration.service.JoltService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class JoltController {

    @Autowired
    JoltService joltService;

    @PostMapping(value = JoltConstant.API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Object> getRequest(@RequestBody String request) {

        if (log.isDebugEnabled()) {
            log.debug("getRequest() : request -> {}", request);
        }
        return joltService.joltTransform(request);
    }
}
