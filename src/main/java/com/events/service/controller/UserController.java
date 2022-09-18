package com.events.service.controller;

import com.events.service.entity.User;
import com.events.service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
