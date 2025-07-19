package com.gary.controller;

import com.gary.product.bean.Product;
import com.gary.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查詢商品
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId, HttpServletRequest request) throws InterruptedException {
        System.out.println("order發送request的header中的token值:" + request.getHeader("token"));
        System.out.println("重試!");
        Product product = productService.getProductById(productId);
        return product;
    }
}
