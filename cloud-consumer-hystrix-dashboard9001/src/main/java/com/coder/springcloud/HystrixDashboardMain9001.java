package com.coder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: cloud2021
 * @classname: HystrixDashboardMain9001
 * @description:
 * @author: 李小飞
 * @create: 2021-03-09 17:10
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    /**
     * 服务监控
     * http://localhost:9001/hystrix
     * http://localhost:8010/hystrix.stream
     * @return
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
