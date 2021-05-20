package com.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */
@Component
public class LoginFilter implements GlobalFilter, Ordered {


    
    //判断是否携带 login cookie
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
//        HttpCookie httpCookie = null;
        for (Map.Entry<String, List<HttpCookie>> cookie : cookies.entrySet()) {
            if (cookie.getKey().equals("login1")) {
                System.out.println(1);
              return   chain.filter(exchange);
            }
        }
        System.out.println(2);
        //认证不通过 返回401错误代码
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
