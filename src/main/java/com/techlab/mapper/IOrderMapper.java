package com.techlab.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.techlab.dto.productOrders.OrderDto;
import com.techlab.entity.Order;



@Mapper(componentModel = "spring", uses = IProductOrderMapper.class)
public interface IOrderMapper extends IBaseMapper<Long, Order, OrderDto>  {

    @Override
    OrderDto toDto(Order entity);

    @Override
    Order toEntity(OrderDto dto);

    @Override
    List<OrderDto> toListDto(List<Order> entities);

    @Override
    @Mapping(target = "id", ignore = true)
    void updateEntity(OrderDto dto, @MappingTarget Order ent);

}
