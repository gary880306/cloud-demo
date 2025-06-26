package com.gary.service.impl;

import com.gary.bean.Product;
import com.gary.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(100));
        product.setProductName("小熊");
        product.setNum(2);
        return product;
    }
}
