package com.coder.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @program: cloud2021
 * @classname: com.coder.springcloud.PaymentHystrixPaymentMain8010
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 16:15
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixPaymentMain8010 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixPaymentMain8010.class, args);
    }

    /**
     * 服务监控
     * http://localhost:9001/hystrix
     * http://localhost:8010/hystrix.stream
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamService");
        return registrationBean;
    }
}
