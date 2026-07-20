package com.techlab.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order extends EntityBase<Long> {

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProductOrder> productOrders;

    public Order() {
    }

    public Order(Long id, String createdBy, String updatedBy, LocalDateTime createDate, LocalDateTime updateDate,
            List<ProductOrder> productOrders) {
        super(id, createdBy, updatedBy, createDate, updateDate);
        this.productOrders = productOrders;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

}
