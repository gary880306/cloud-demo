package com.gary.predicate;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {

    // 傳入內部內config
    public CustomRoutePredicateFactory() {
        super(CustomRoutePredicateFactory.Config.class);
    }

    // 定義短寫法傳參數順序
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "value");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // localhost/search?q=gary&user=shan
                ServerHttpRequest request = serverWebExchange.getRequest();
                String first = request.getQueryParams().getFirst(config.getParam());
                return StringUtils.hasText(first) && first.equals(config.getValue());
            }
        };
    }

    // 可以配置的參數
    @Validated
    public static class Config {

        @NotEmpty
        private String param; // user

        @NotEmpty
        private String value; // shan

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
