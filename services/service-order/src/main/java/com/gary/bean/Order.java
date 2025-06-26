package com.gary.bean;

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
    private List<Object> productList;
}
