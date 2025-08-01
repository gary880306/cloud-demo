package com.gary.service.impl;

import com.gary.product.bean.Product;
import com.gary.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) throws InterruptedException {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(100));
        product.setProductName("小熊");
        product.setNum(2);
//        TimeUnit.SECONDS.sleep(100); // 模擬feign讀取超時
        return product;
    }
}
