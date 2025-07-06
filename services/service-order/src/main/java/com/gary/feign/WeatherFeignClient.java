package com.gary.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather-client", url = "https://opendata.cwa.gov.tw")
public interface WeatherFeignClient {

    @GetMapping("/api/v1/rest/datastore/F-C0032-001")
    String getWeather(@RequestHeader("Authorization") String auth, @RequestParam("locationName") String locationName);

}
