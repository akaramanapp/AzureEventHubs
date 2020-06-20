package com.azurehubs.applicationlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class EventhubSink {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventhubSink.class);

    @StreamListener(Sink.INPUT)
    public void handleProductMessage(String productName) {
        LOGGER.info("New product message received: '{}'", productName);
    }
}
