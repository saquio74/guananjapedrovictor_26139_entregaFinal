package com.techlab.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import com.techlab.dto.productOrders.ProductOrderDto;
import com.techlab.entity.ProductOrder;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductOrderMapper {

    ProductOrderDto toDto(ProductOrder entity);

    ProductOrder toEntity(ProductOrderDto dto);

    List<ProductOrderDto> toListDto(List<ProductOrder> entities);

    void updateEntity(ProductOrderDto dto, @MappingTarget ProductOrder ent);

}
