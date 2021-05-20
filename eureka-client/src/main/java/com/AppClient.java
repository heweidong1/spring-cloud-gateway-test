package com;

import com.feign.UserFeignClient;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.guice.EurekaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients()
@EnableHystrix
public class AppClient {

    public static void main(String[] args) {
//        EurekaModule s = new EurekaModule();
//        s.
//        DiscoveryManager.getInstance().shutdownComponent();;
        SpringApplication.run(AppClient.class);
    }
}
