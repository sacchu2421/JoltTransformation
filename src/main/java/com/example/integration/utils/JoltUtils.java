package com.example.integration.utils;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.example.integration.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;

@Slf4j
@Component
public class JoltUtils {


    public Mono<Object> transform(String joltInput, String joltSpec) {

        try {
            Base64.Decoder decoder = Base64.getDecoder();
            String decodedJolt = new String(decoder.decode(joltSpec));
            if (log.isDebugEnabled()) {
                log.debug("transform() : decodedJoltSpec -> {}", decodedJolt);
            }

            List<Object> specs = JsonUtils.jsonToList(decodedJolt);
            Chainr chainr = Chainr.fromSpec(specs);

            Object outputJolt = chainr.transform(JsonUtils.jsonToObject(joltInput));
            String joltOutput = JsonUtils.toJsonString(outputJolt);
            if (log.isInfoEnabled()) {
                log.info("transform() : joltOutput -> {}", joltOutput);
            }
            return Mono.just(joltOutput);

        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("transform() : Exception : joltInput -> {}, Exception -> {} : {}", joltInput, e.getMessage(), e);
            }
            //TODO resolve return of error
            return Mono.just(ResponseEntity.badRequest().body(new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST.value())));
        }
    }
}


