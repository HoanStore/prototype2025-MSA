package com.hoan.userservice.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @GetMapping({"", "/"})
    public String index() {
        return "Hello User service";
    }

    @GetMapping("/{id}")
    public Map<String, String> getUser(@PathVariable String id) {
        return Map.of("id", id, "name", "User " + id, "email", "user" + id + "@example.com");
    }
}
