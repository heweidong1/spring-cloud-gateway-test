package com.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */
@Configuration
public class AppCoonfig {


    //userKey 用于配置文件中的限流操作
    //根据userKey 返回的用户唯一标识 发放令牌
    @Bean
    public KeyResolver userKey(){

        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                ServerHttpRequest request = exchange.getRequest();
                HttpCookie userCookie = null;
                for (Map.Entry<String, List<HttpCookie>> cookies : request.getCookies().entrySet()) {
                    if (cookies.getKey().equals("login1")) {
                        userCookie = cookies.getValue().get(0);
                    }
                }
                return Mono.just(userCookie.getValue()); //
            }
        };
    }
}
