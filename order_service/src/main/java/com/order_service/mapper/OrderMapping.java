package com.order_service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.order_service.dto.OrderItemResponse;
import com.order_service.dto.OrderRequest;
import com.order_service.dto.OrderResponse;
import com.order_service.entity.Order;
import com.order_service.entity.OrderItem;

public interface OrderMapping {
	
	
	public static Order toEntity(OrderRequest request) {
        Order order = new Order();
        BeanUtils.copyProperties(request, order);

        if (request.getItems() != null) {
            List<OrderItem> items = request.getItems()
                    .stream()
                    .map(OrderItemMapper::toEntity)
                    .collect(Collectors.toList());
            items.forEach(item -> item.setOrder(order)); // back-reference
            order.setOrderItem(items);
        }
        return order;
    }

    // Entity → Response
    public static OrderResponse toDto(Order order) {
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(order, response);

        if (order.getOrderItem() != null) {
            List<OrderItemResponse> itemDtos = order.getOrderItem()
                    .stream()
                    .map(OrderItemMapper::toDto)
                    .collect(Collectors.toList());
            response.setItems(itemDtos);
        }
        return response;
    }

}
