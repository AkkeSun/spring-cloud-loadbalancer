package com.example.springcloudloadbalancer;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public abstract class AbstractServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    private final String serviceId;
    private final AtomicInteger serviceCount = new AtomicInteger(1);

    @Override
    public String getServiceId() {
        return serviceId;
    }

    public DefaultServiceInstance createDefaultServiceInstance(final String host, final int port, final boolean secure) {
        return new DefaultServiceInstance(getServiceId() + serviceCount.getAndIncrement(), getServiceId(), host, port, secure);
    }

    public DefaultServiceInstance createDefaultServiceInstance(final String host, final int port) {
        return new DefaultServiceInstance(getServiceId() + serviceCount.getAndIncrement(), getServiceId(), host, port, false);
    }
}