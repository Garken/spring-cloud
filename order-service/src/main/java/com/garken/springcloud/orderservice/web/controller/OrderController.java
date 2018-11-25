package com.garken.springcloud.orderservice.web.controller;

import com.garken.springcloud.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{orderNumber}")
    public Order getOrderInfo(@PathVariable("orderNumber") String orderNumber) {

        Order order = new Order();
        order.setOrderNumber(orderNumber);

        String uri = "http://member-service/rest/member/1";
        String memberInfo = restTemplate.getForObject(uri, String.class);

        order.setMemberInfo(memberInfo);
        return order;
    }

}
