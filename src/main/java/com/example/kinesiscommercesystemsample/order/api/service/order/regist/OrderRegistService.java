package com.example.kinesiscommercesystemsample.order.api.service.order.regist;

import com.example.kinesiscommercesystemsample.order.api.controller.OrderApiController;

public interface OrderRegistService {

	OrderRegistResult execute(OrderApiController.OrderRegistRequest request);
}
