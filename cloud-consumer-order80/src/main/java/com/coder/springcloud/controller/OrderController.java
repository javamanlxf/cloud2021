package com.coder.springcloud.controller;

import com.coder.springcloud.entities.CommonResult;
import com.coder.springcloud.entities.Payment;
import com.coder.springcloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @program: cloud2021
 * @classname: OrderController
 * @description: 订单 controller
 * @author: 李小飞
 * @create: 2021-03-06 19:53
 **/
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ILoadBalancer loadBalancer;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("订单系统，添加订单：" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("订单系统，获取订单: " + id);
        return restTemplate.getForObject(PAYMENT_URL + "payment/getPaymentById/" + id, CommonResult.class);
    }

    @PostMapping("/consume/forentityr/payment/create")
    public CommonResult createEntity(@RequestBody Payment payment) {
        log.info("订单系统，添加订单：" + payment);
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL + "payment/create", payment, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult(responseEntity.getStatusCodeValue(), "请求失败");
        }
    }

    @GetMapping("/consumer/forentity/payment/getPaymentById/{id}")
    public CommonResult getPaymentByIdEntity(@PathVariable("id") Long id) {
        log.info("订单系统，获取订单: " + id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "payment/getPaymentById/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(entity.getStatusCodeValue(), "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("采用的服务uri：" + uri.toString());
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
