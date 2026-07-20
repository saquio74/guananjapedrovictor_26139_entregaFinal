package com.techlab.dto.productOrders;

import java.util.List;

public class OrderDto {
    private Long id;
    private List<ProductOrderDto> productOrders;

    public OrderDto() {
    }

    public OrderDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductOrderDto> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderDto> productOrders) {
        this.productOrders = productOrders;
    }

    
}
