package com.petstore.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@RestController
public class MessageController {

    @Value("${message:Default message}")
    private String message;

    @RequestMapping("/message")
    public String getMessage() {
        return this.message;
    }
}