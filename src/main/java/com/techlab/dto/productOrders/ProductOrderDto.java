package com.techlab.dto.productOrders;

public class ProductOrderDto {
    private long units;

    private double total;

    private ProductDto product;

    public ProductOrderDto() {
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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto productDto) {
        this.product = productDto;
    }

    
}
