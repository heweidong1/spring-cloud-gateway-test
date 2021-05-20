package com.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */
//如果穿微服务名字 会结合ribbon调用 并且做负载均衡
    //如果只穿url 他并不会 结合 Ribbon 而是直接构建请求发送
@FeignClient(value = "service-user")
public interface UserFeignClient {

    @RequestMapping("getUser")
     String getUser(@RequestParam("name") String name);

}
