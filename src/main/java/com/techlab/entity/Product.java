package com.techlab.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends EntityBase<Long> {
    private String nombre;
    private Double precio;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders = new ArrayList<>();

    public Product(Long id, String createdBy, String updatedBy, LocalDateTime createDate, LocalDateTime updateDate,
            String nombre, Double precio) {
        super(id, createdBy, updatedBy, createDate, updateDate);
        this.nombre = nombre;
        this.precio = precio;
    }

    public Product() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
