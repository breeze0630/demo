package com.example.orderservicemylb9003.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalancerClient {

    ServiceInstance instances(List<ServiceInstance> list);
}
