package com.techlab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productorder")
@IdClass(ProductOrderId.class)
public class ProductOrder {

    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private long units;

    private double total;

    public ProductOrder() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getUnits() {
        return units;
    }

    public void setUnits(long units) {
        this.units = units;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}