package com.techlab.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.techlab.dto.productOrders.ProductDto;
import com.techlab.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper extends IBaseMapper<Long, Product, ProductDto>  {

    @Override
    ProductDto toDto(Product entity);

    @Override
    Product toEntity(ProductDto dto);

    @Override
    List<ProductDto> toListDto(List<Product> entities);

    @Override
    @Mapping(target = "id", ignore = true)
    void updateEntity(ProductDto dto, @MappingTarget Product ent);

}
