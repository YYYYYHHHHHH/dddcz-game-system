package com.example.demo.controller;

import java.util.List;

import com.example.demo.dao.AuthUserDao;
import com.example.demo.entity.AuthUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/user")
public class AuthUserController {
    @Autowired
    private AuthUserDao authUserDao;

    @GetMapping("/users")
    List<AuthUser> getUsers() {
        return authUserDao.queryAll(new AuthUser());
    }

    @PostMapping("/users")
    int addUser(@RequestBody AuthUser user) {
        return authUserDao.insert(user);
    }

    @DeleteMapping("/users/{id}")
    int deleteUser(@PathVariable("id") int id) {
        return authUserDao.deleteById(id);

    }

    @PutMapping("/users")
    int editUser(@RequestBody AuthUser user) {
        return authUserDao.update(user);
    }

}
