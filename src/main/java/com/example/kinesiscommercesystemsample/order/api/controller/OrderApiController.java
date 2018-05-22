package com.example.kinesiscommercesystemsample.order.api.controller;

import com.example.kinesiscommercesystemsample.common.web.base.controller.api.AbstractRestController;
import com.example.kinesiscommercesystemsample.common.web.base.controller.api.resource.Resource;
import com.example.kinesiscommercesystemsample.common.web.base.controller.api.resource.ResourceFactory;
import com.example.kinesiscommercesystemsample.common.web.base.dto.Dto;
import com.example.kinesiscommercesystemsample.order.api.service.order.regist.OrderRegistResult;
import com.example.kinesiscommercesystemsample.order.api.service.order.regist.OrderRegistService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = {"/order"})
@Slf4j
public class OrderApiController extends AbstractRestController {

	@Autowired
	private OrderRegistService orderRegistService;

	@PostMapping(value = "/regist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource regist(@RequestBody OrderRegistRequest request) {

		OrderRegistResult orderRegistResult = orderRegistService.execute(request);

		val response = new OrderRegistResponse(orderRegistResult.getMessageId());
		val responses = new ArrayList<Dto>();
		responses.add(response);

		Resource resource = ResourceFactory.create();
		resource.setData(responses);
		resource.setMessage(getMessage(SUCCESS));

		return resource;
	}

	@Getter
	@Setter
	@ToString
	public static class OrderRegistRequest implements Dto {

		/**
		 * 商品ID
		 */
		@JsonProperty("item_id")
		private String itemId;

		/**
		 * 数量
		 */
		@JsonProperty("quantity")
		private Integer quantity;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public static class OrderRegistResponse implements Dto {

		/**
		 * 発番されたメッセージID
		 */
		@JsonProperty("message_id")
		private String messageId;
	}
}
