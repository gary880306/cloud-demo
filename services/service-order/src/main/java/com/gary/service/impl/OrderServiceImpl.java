package com.gary.service.impl;

import com.gary.order.bean.Order;
import com.gary.product.bean.Product;
import com.gary.service.OrderService;
import com.gary.feign.ProductFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
//        Product product = getProductFromRemoteWithLoadBalancerAnnotation(productId);
        Product product = productFeignClient.getProductById(productId);
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmt(product.getPrice().multiply(new BigDecimal(product.getNum()))); // 遠程調用product
        order.setUserId(userId);
        order.setNickName("gary");
        order.setAddress("文山區");
        order.setProductList(Arrays.asList(product)); // 遠程調用product
        return order;
    }

    // 查詢商品
    public Product getProductFromRemote (Long productId) {
        // 1. 取得所有註冊中心實例
        List<ServiceInstance> instances = discoveryClient.getInstances("server-product");
        // 2. 獲取第一個實例
        ServiceInstance serviceInstance = instances.get(0);
        // 3. 創建 url 獲取商品資訊
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + productId;
        log.info("遠程調用url: " + url);
        // 4. 利用 restTemplate 調用並返回
        return restTemplate.getForObject(url, Product.class);
    }

    // 查詢商品(負載均衡版)
    public Product getProductFromRemoteWithLoadBalancer (Long productId) {
        // 1. 取得單個實例
        ServiceInstance choose = loadBalancerClient.choose("server-product");
        // 2. 創建 url 獲取商品資訊
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/" + productId;
        log.info("遠程調用url: " + url);
        // 3. 利用 restTemplate 調用並返回
        return restTemplate.getForObject(url, Product.class);
    }

    // 查詢商品(負載均衡版-利用註解)
    public Product getProductFromRemoteWithLoadBalancerAnnotation (Long productId) {
        // 1. 創建 url 獲取商品資訊
        String url = "http://server-product/product/" + productId;
        log.info("遠程調用url: " + url);
        // 2. 利用 restTemplate 調用並返回
        return restTemplate.getForObject(url, Product.class);
    }


}
