package com.gary.product;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    private DiscoveryClient discoveryClient; // 適用所有註冊中心

    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery; // 只有 nacos 才可調

    @Test
    void discoveryClientTest () {
        for (String service : discoveryClient.getServices()) {
            System.out.println("service =" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + ":" + "port:" + instance.getPort());
            }
        }
    }

    @Test
    void nacosServiceDiscoveryTest () throws NacosException {
        for (String service : nacosServiceDiscovery.getServices()) {
            System.out.println("service =" + service);
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + ":" + "port:" + instance.getPort());
            }
        }
    }
}
