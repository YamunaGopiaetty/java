package com.order_service.mapper;

import org.springframework.beans.BeanUtils;

import com.order_service.dto.OrderItemRequest;
import com.order_service.dto.OrderItemResponse;
import com.order_service.entity.OrderItem;

public interface OrderItemMapper {
	
	public static OrderItem toEntity(OrderItemRequest request) {
        OrderItem item = new OrderItem();
        BeanUtils.copyProperties(request, item);
        return item;
    }

    // Entity → Response
    public static OrderItemResponse toDto(OrderItem item) {
        OrderItemResponse response = new OrderItemResponse();
        BeanUtils.copyProperties(item, response);
        return response;
    }

}
