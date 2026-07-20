package com.techlab.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.dto.productOrders.OrderDto;
import com.techlab.entity.Order;
import com.techlab.filter.FilterBase;
import com.techlab.mapper.IOrderMapper;
import com.techlab.repository.OrderRepository;
import com.techlab.service.implementation.OrderService;


@RestController
@RequestMapping("api/order")
public class OrderController extends
        BaseController<Long, Order, OrderDto, OrderRepository, IOrderMapper, OrderService, FilterBase> {

    public OrderController(OrderService service) {
        super(service);
    }

}
