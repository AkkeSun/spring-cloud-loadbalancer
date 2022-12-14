package com.example.springcloudloadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
@LoadBalancerClient(name = "web-service", configuration = LoadbalancerConfig.WebServiceConfig.class)
public class LoadbalancerConfig {

    public static class WebServiceConfig {
        @Bean
        public ServiceInstanceListSupplier serviceInstanceListSupplier() {
            return new AbstractServiceInstanceListSupplier("web-service") {
                @Override
                public Flux<List<ServiceInstance>> get() {
                    return Flux.just(List.of(createDefaultServiceInstance("localhost", 8081)));
                }
            };
        }
    }
}