package com.hoan.orderservice.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderRestController {

    @GetMapping({"", "/"})
    public String index() {
        return "Hello Order service";
    }

    @GetMapping("/{id}")
    public Map<String, String> getOrder(@PathVariable String id) {
        return Map.of("id", id, "userId", "1", "product", "Laptop", "status", "Shipped");
    }
}
