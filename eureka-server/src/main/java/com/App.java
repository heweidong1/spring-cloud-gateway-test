package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */

@SpringBootApplication
@EnableEurekaServer
//@SpringBootConfiguration
public class App {

    public static void main(String[] args) {

        System.out.println(AnnotationUtils.findAnnotation(App.class, Configuration.class));
        SpringApplication.run(App.class);
    }
}
