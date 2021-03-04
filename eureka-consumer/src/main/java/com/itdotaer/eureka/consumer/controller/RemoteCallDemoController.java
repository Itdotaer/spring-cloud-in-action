package com.itdotaer.eureka.consumer.controller;

import com.itdotaer.eureka.consumer.dto.TestDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * RemoteCallDemoController
 *
 * @author jt_hu
 * @date 2021/3/1
 */
@RestController
@RequestMapping("demo")
public class RemoteCallDemoController {

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/queryremote")
    public List<TestDto> query() {
        System.out.println("query remote");
        ParameterizedTypeReference<List<TestDto>> parameterizedTypeReference =
                new ParameterizedTypeReference<List<TestDto>>() {
                };

        ResponseEntity<List<TestDto>> exchange = restTemplate.exchange("http://eureka-provider/demo/query", HttpMethod.POST, null, parameterizedTypeReference);
        return exchange.getBody();
    }

}
