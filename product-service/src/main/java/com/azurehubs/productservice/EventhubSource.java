package com.azurehubs.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class EventhubSource {

    @Autowired
    private Source source;

    @PostMapping("/product")
    public String addProduct(@RequestBody String productName) {
        this.source.output().send(new GenericMessage<>(productName));
        return productName;
    }
}
