package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */

@RestController
public class FallbackController {


    @RequestMapping("/fallback")
    public Object fallback(){


        return "降级";
    }
}
