package com.gary.controller;

import com.gary.product.bean.Product;
import com.gary.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查詢商品
    @GetMapping("/product/{id}")
    public Product getProduct (@PathVariable("id") Long productId) throws InterruptedException {
        System.out.println("重試!");
        Product product = productService.getProductById(productId);
        return product;
    }
}
