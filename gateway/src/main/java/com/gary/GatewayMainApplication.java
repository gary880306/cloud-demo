package com.gary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // 服務發現
@SpringBootApplication
public class GatewayMainApplication {
    public static void main(String[] args) {

        SpringApplication.run(GatewayMainApplication.class, args);

    }
}