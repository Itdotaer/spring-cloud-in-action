package com.itdotaer.eureka.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * EurekaProviderApplication
 *
 * @author jt_hu
 * @date 2021/3/1
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

    @Bean
    CommandLineRunner runner(DiscoveryClient dc) {
        return args -> {
            dc.getInstances("eureka-provider")
                    .forEach(si -> System.out.println(String.format(
                            "Found %s %s:%s;Uri %s", si.getServiceId(), si.getHost(), si.getPort(), si.getUri())));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}
