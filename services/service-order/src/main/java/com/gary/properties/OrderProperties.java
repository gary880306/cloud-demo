package com.gary.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order") // 配置批量綁定在Nacos下，可以無需@RefreshScope即可實現自動刷新
@Data
public class OrderProperties {

    private String test1;
    private String test2;

    private String timeOut;
    private String autoConfirm;
    private String dbUrl;
}
