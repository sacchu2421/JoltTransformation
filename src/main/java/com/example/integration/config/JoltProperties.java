package com.example.integration.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
public class JoltProperties {

    @Value("${jolt.spec}")
    private String joltSpec;
}
