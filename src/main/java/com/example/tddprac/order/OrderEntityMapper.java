package com.example.tddprac.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEntityMapper {

    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

    Order toModel(OrderEntity entity);

    @Mapping(target = "productEntity", source = "order.product")
    OrderEntity toEntity(Order order);

}
