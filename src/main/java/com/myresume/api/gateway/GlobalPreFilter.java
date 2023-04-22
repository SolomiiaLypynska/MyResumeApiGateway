package com.myresume.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class GlobalPreFilter implements GlobalFilter, Ordered {

    private final Logger log = LoggerFactory.getLogger(GlobalPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("GlobalPreFilter executed...");

        String requestPath = exchange.getRequest().getPath().toString();

        log.info("Request path is {}", requestPath);

        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();

        Set<String> headerNames = httpHeaders.keySet();

        headerNames.forEach(headerName -> {
           String headerValue = httpHeaders.getFirst(headerName);
           log.info("Header value is {}", headerValue);
        } );

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
