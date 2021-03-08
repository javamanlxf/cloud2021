package com.coder.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2021
 * @classname: MyRibbonRule
 * @description: ribbon 负载均衡规则 必须放在componentScan之外，否则会被所有模块共享，不能做到特定配置
 * @author: 李小飞
 * @create: 2021-03-08 10:36
 **/
@Configuration
public class MyRibbonRule {


    @Bean
    public IRule myRule() {
        return new RandomRule(); // 定义为随机
    }
}
