package com.myresume.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {

    private final Logger log = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

    @Order(1)
    @Bean
    public GlobalFilter secondPreFilter() {
        return (exchange, chain) -> {
            log.info("Second GlobalFiltersConfiguration is executed...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Second GlobalFiltersConfiguration was executed...");
            }));
        };
    }

    @Order(2)
    @Bean
    public GlobalFilter thirdPreFilter() {
        return (exchange, chain) -> {
            log.info("Third GlobalFiltersConfiguration is executed...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Third GlobalFiltersConfiguration was executed...");
            }));
        };
    }
}
