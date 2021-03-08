package com.coder.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2021
 * @description: loadbalance 负载均衡
 * @author: Mr.Lee
 * @create: 2021-03-08 11:08
 **/
public interface ILoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
