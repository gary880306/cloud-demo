package com.gary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        // 負載均衡(輪巡)
        ServiceInstance choose = loadBalancerClient.choose("server-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("server-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("server-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("server-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalancerClient.choose("server-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
    }
}
