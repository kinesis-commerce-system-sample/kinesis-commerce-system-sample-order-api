package com.example.kinesiscommercesystemsample.order.api.service.order.regist;

import com.eaio.uuid.UUID;
import com.example.kinesiscommercesystemsample.common.messaging.order.entity.v1.OrderRegistMessage;
import com.example.kinesiscommercesystemsample.common.messaging.order.mom.writer.AbstractOrderStreamWriter;
import com.example.kinesiscommercesystemsample.order.api.controller.OrderApiController;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRegistServiceImpl implements OrderRegistService {

	@Autowired
	private AbstractOrderStreamWriter orderStreamWriter;

	@Override
	public OrderRegistResult execute(OrderApiController.OrderRegistRequest request) {

		try {

			val messageId = new UUID().toString();
			val orderId = new UUID().toString();

			val itemId = request.getItemId();
			val quantity = request.getQuantity();

			// TODO : derive domain model

			val message = new OrderRegistMessage(messageId, orderId, itemId, quantity);

			orderStreamWriter.write(message);

			val result = new OrderRegistResult();
			result.setMessageId(messageId);
			result.setOrderId(orderId);

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
