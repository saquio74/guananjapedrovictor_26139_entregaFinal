package com.techlab.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.dto.productOrders.ProductDto;
import com.techlab.entity.Product;
import com.techlab.filter.FilterBase;
import com.techlab.mapper.IProductMapper;
import com.techlab.repository.ProductRepository;
import com.techlab.service.implementation.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController extends
        BaseController<Long, Product, ProductDto, ProductRepository, IProductMapper, ProductService, FilterBase> {

    public ProductController(ProductService service) {
        super(service);
    }

}
