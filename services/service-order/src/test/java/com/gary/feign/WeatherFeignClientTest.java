package com.gary.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherFeignClientTest {

    @Autowired
    private WeatherFeignClient weatherFeignClient;

    private String auth = ""; // 需填入API授權碼

    @Test
    public void getWeather() {
        String result = weatherFeignClient.getWeather(auth, "%E8%87%BA%E5%8C%97%E5%B8%82"); // 台北市
        System.out.println(result);
    }

}
