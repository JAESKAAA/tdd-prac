package com.example.tddprac.product.adapter.out.persistence.mapper;

import com.example.tddprac.product.adapter.out.persistence.ProductEntity;
import com.example.tddprac.product.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper {

    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    Product toModel(ProductEntity entity);

    ProductEntity toEntity(Product product);


}
