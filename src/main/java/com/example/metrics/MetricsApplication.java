package com.example.metrics;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class MetricsApplication {

    @RestController
    public static class HelloWorld {
        @RequestMapping("/")
        public String helloWorld() {
            return "Hello World";
        }
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return (registry) -> registry.config().commonTags("product", "MetricsApplication");
    }

    @Component
    public static class ZeroToHundredGauge {

        private Random random = new Random();

        public ZeroToHundredGauge(MeterRegistry registry) {
            Gauge
            .builder("zero_to_hundred_gauge", () -> {
                return random.nextInt(100);
            })
            .register(registry);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MetricsApplication.class, args);
    }

}
