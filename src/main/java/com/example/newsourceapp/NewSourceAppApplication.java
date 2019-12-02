package com.example.newsourceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

@SpringBootApplication
public class NewSourceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewSourceAppApplication.class, args);
    }

    @Bean
    public Supplier<Flux<String>> emit() {
        return () -> Flux.interval(Duration.ofMillis(10))
                         .map(aLong -> aLong+"")
                         .log();
    }

}
