package com.bfhl.qualifier;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/bfhl")
    public Map<String, Object> handleWebhook(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Webhook received!");
        response.put("data", payload);
        return response;
    }

    @GetMapping("/")
    public String home() {
        return "BFHL Qualifier Auto Webhook Running!";
    }
}
