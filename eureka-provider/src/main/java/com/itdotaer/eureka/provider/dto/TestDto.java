package com.itdotaer.eureka.provider.dto;

/**
 * DemoDto
 *
 * @author jt_hu
 * @date 2021/3/1
 */
public class TestDto {

    private Long id;
    private String message;

    public TestDto() {

    }

    public TestDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
