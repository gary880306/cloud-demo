package com.gary.feign;

import com.gary.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-product", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
