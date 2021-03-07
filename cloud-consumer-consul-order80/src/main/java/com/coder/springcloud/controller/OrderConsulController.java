package com.coder.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.List;

/**
 * @program: cloud2021
 * @classname: OrderConsulController
 * @description: controller
 * @author: 李小飞
 * @create: 2021-03-07 20:57
 **/
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        log.info(result);
        return result;
    }

    @GetMapping(value = "/payment/discovery/consul")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance : instances) {
            String info = MessageFormat.format("serviceId:[{0}]\thost:[{1}]\tport:[{2}]\turi:[{3}]", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri().toString());
            log.info(info);
        }
        return this.discoveryClient;
    }
}
