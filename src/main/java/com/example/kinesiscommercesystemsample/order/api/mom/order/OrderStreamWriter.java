package com.example.kinesiscommercesystemsample.order.api.mom.order;

import com.example.kinesiscommercesystemsample.common.messaging.order.entity.OrderMessage;
import com.example.kinesiscommercesystemsample.common.messaging.order.mom.writer.AbstractOrderStreamWriter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class OrderStreamWriter extends AbstractOrderStreamWriter {

	@Value("${application.kinesis.order.stream-name}")
	private String streamName;

	@Override
	public void write(OrderMessage message) {
		super.write(message);
	}

}
