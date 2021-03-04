package com.itdotaer.eureka.provider.controller;

import com.itdotaer.eureka.provider.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * DemoController
 *
 * @author jt_hu
 * @date 2021/3/1
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @PostMapping("/query")
    public List<TestDto> query() {
        List<TestDto> dtos = new ArrayList<>();

        TestDto testDto = new TestDto();
        testDto.setId(123L);
        testDto.setMessage("hello world");

        dtos.add(testDto);

        return dtos;
    }

    @PostMapping("/")
    public List<TestDto> hi() {
        List<TestDto> dtos = new ArrayList<>();

        TestDto testDto = new TestDto();
        testDto.setId(123L);
        testDto.setMessage("hello world");

        dtos.add(testDto);

        return dtos;
    }

}
