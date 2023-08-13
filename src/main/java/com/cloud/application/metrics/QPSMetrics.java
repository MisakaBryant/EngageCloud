package com.cloud.application.metrics;

import io.prometheus.client.Gauge;
import io.prometheus.client.CollectorRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QPSMetrics {

    private final Gauge qps;

    private long count = 0;

    public QPSMetrics(CollectorRegistry collectorRegistry) {
        qps = Gauge.build()
                .name("my_qps")
                .help("The average number of requests per second over the previous minute")
                .register(collectorRegistry);
    }

    // 由 Controller 调用
    public synchronized void increment() {
        count++;
    }

    // 每秒报告 QPS
    @Scheduled(fixedRate = 1000)
    public void report() {
        qps.set(count / 60.0);
    }

    // 每分钟重置访问次数
    @Scheduled(fixedRate = 60000)
    public void reset() {
        count = 0;
    }
}
