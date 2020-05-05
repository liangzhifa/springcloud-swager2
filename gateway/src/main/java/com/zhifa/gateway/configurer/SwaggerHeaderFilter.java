package com.zhifa.gateway.configurer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@SuppressWarnings("rawtypes")
//@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
 
    private static final String HEADER_NAME = "X-Forwarded-Prefix";
 
    //private static final String HOST_NAME = "X-Forwarded-Host";
 
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            exchange.getRequest();          
            String path = request.getURI().getPath();
            System.out.println("========================");
            System.out.println(path);
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            String basePath = path.substring(0, path.lastIndexOf(SwaggerProvider.API_URI));
            System.out.println("========================");
            System.out.println(basePath);
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
 
        };
 
    }

}
