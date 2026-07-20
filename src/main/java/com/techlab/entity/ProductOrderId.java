package com.techlab.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductOrderId implements Serializable {

    private Long product;
    private Long order;

    public ProductOrderId() {
    }

    public ProductOrderId(Long product, Long order) {
        this.product = product;
        this.order = order;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrderId)) return false;
        ProductOrderId that = (ProductOrderId) o;
        return Objects.equals(product, that.product) &&
               Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}