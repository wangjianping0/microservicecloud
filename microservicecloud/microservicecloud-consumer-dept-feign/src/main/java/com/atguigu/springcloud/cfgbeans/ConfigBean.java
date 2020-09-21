package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //Springcloud Ribbon是基于Netflix Ribbon 实现的一套客户端 负载均衡 工具.
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
//        return  new RoundRobinRule();//按照顺序选择server（ribbon默认策略）
//        return  new RandomRule();//随机选择server
//        return  new RetryRule();//在一个配置时间段内，当选择server不成功，则一直尝试选择一个可用的server
        return  new ZoneAvoidanceRule();//综合判断server所在区域的性能，和server的可用性，轮询选择server并且判断一个AWS Zone的运行性能是否可用，剔除不可用的Zone中的所有server
    }
}
