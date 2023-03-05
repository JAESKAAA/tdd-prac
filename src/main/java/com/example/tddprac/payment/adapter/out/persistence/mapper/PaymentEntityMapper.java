package com.example.tddprac.payment.adapter.out.persistence.mapper;

import com.example.tddprac.payment.adapter.out.persistence.PaymentEntity;
import com.example.tddprac.payment.domain.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentEntityMapper {

    PaymentEntityMapper INSTANCE = Mappers.getMapper(PaymentEntityMapper.class);

    PaymentEntity toEntity(Payment payment);

    Payment toModel(PaymentEntity entity);

}
