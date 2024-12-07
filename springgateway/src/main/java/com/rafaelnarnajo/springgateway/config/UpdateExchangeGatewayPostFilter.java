package com.rafaelnarnajo.springgateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

@Component
public class UpdateExchangeGatewayPostFilter extends AbstractGatewayFilterFactory<UpdateExchangeGatewayPostFilter.Config> {
    private final JwtDecoder jwtDecoder;

    public UpdateExchangeGatewayPostFilter(JwtDecoder jwtDecoder) {
        super(Config.class);
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            String token = authHeader.substring(7);
            Jwt jwt = jwtDecoder.decode(token);

            var builder = exchange.getRequest().mutate();
            builder.header("x-custom-username", jwt.getClaims().get("preferred_username").toString());

            return chain.filter(exchange.mutate().request(builder.build()).build());
        });
    }

    public static class Config {}

}
