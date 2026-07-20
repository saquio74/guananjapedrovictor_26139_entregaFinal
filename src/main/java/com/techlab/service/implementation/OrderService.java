package com.techlab.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.dto.productOrders.OrderDto;
import com.techlab.dto.productOrders.ProductOrderDto;
import com.techlab.entity.Order;
import com.techlab.entity.ProductOrder;
import com.techlab.mapper.IOrderMapper;
import com.techlab.repository.OrderRepository;
import com.techlab.repository.ProductRepository;

@Service
public class OrderService extends BaseService<Long, Order, OrderDto, OrderRepository, IOrderMapper> {

    private final ProductRepository productRepository;

    public OrderService(
            OrderRepository repository,
            IOrderMapper mapper,
            ProductRepository productRepository
    ) {
        super(repository, mapper);
        this.productRepository = productRepository;
    }


    @Override
    protected Order createData(OrderDto dto) {

        Order order = new Order();

        List<ProductOrder> productOrders = dto.getProductOrders()
                .stream()
                .map(productOrderDto -> createProductOrder(productOrderDto, order))
                .toList();

        order.setProductOrders(productOrders);

        return order;
    }


    private ProductOrder createProductOrder(ProductOrderDto dto, Order order) {

        ProductOrder productOrder = new ProductOrder();

        productOrder.setProduct(
                productRepository.getReferenceById(
                        dto.getProduct().getId()
                )
        );

        productOrder.setOrder(order);

        productOrder.setUnits(dto.getUnits());

        return productOrder;
    }
}
