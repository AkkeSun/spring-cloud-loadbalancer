package com.example.springcloudloadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringCloudLoadbalancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLoadbalancerApplication.class, args);
    }

}
