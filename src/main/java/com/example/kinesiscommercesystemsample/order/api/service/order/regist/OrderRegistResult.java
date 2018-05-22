package com.example.kinesiscommercesystemsample.order.api.service.order.regist;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderRegistResult {

	private String messageId;

	private String orderId;
}
