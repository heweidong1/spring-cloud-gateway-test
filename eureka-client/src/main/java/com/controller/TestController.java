package com.controller;

import com.feign.UserFeignClient;
import com.netflix.client.http.HttpResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */
@RestController
public class TestController {


    //改变了spring ioc的行为
    @Autowired
    UserFeignClient userFeignClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("test.do")
    @HystrixCommand(fallbackMethod = "testFallback")
    public Object test() {
        HttpServletResponse r = null;

//        Proxy.newProxyInstance()
//        restTemplate.setI
//        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
//        interceptors.add(0,);
        System.out.println(1);
        return  restTemplate.getForObject("http://service-user//getUser?name=111",String.class);
    }

    public Object testFallback(){
        return "降级";
    }



    @RequestMapping("test1.do")
    public Object getUser(String name){
      return  userFeignClient.getUser(name);

    }

}
