package com.gary.order.bean;

import com.gary.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmt;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
