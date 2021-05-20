package com.config;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.PollingServerListUpdater;
import com.netflix.loadbalancer.ServerListUpdater;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 需要视频资料或咨询课程的同学可以添加若曦老师的QQ:2746251334
 */

@Configuration
public class AppConfig {




    @Bean
    public IPing iPing(){
        //可以自己写一个类 实现 IPing

        //作业: 如果去做ping 逻辑隔离
        // user    power
        return new PingUrl();
    }


//    @Bean
////    @ConditionalOnMissingBean
//    public IClientConfig ribbonClientConfig() {
//        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
//        config.loadProperties("service-user");
//        config.set(CommonClientConfigKey.ConnectTimeout, 1000);
//        config.set(CommonClientConfigKey.ReadTimeout, 1000);
//        config.set(CommonClientConfigKey.GZipPayload, true);
//        return config;
//    }
//
//    @Bean
//    public ServerListUpdater serverListUpdater(IClientConfig clientConfig){
//
//        clientConfig.set(CommonClientConfigKey.ServerListRefreshInterval,10*1000);
//        return  new PollingServerListUpdater(clientConfig);
//    }


    @Bean
    @LoadBalanced
//    @ConditionalOnMissingBean
    public RestTemplate restTemplate(){

        return  new RestTemplate();
    }




    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate1(){

        return  new RestTemplate();
    }


}
