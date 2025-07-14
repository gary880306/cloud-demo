package com.gary.feign;

import com.gary.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {


    @Override
    public Product getProductById(Long id) {
        System.out.println("第三方兜底回調......");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal(0));
        product.setProductName("未知商品");
        product.setNum(0);
        return product;
    }
}
