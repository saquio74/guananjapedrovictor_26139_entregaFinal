package com.techlab.service.implementation;

import org.springframework.stereotype.Service;

import com.techlab.dto.productOrders.ProductDto;
import com.techlab.entity.Product;
import com.techlab.mapper.IProductMapper;
import com.techlab.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Long, Product, ProductDto, ProductRepository, IProductMapper> {

    public ProductService(ProductRepository repository, IProductMapper mapper) {
        super(repository, mapper);
    }

}
