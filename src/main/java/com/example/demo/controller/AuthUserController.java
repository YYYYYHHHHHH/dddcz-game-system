package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.AuthUser;
import com.example.demo.exception.UserException;
import com.example.demo.serviceImpl.AuthUserServiceImpl;
import com.example.demo.status.UserResultCode;

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
    private AuthUserServiceImpl authUserService;

    @PostMapping("/login")
    AuthUser login(@RequestBody AuthUser user) throws UserException {
        AuthUser res = authUserService.login(user);
        if (res.equals(null))
            throw new UserException(UserResultCode.LOGIN_FAILD);

        return res;
    }

    @GetMapping("/users")
    List<AuthUser> getUsers() {
        return authUserService.getUsers();
    }

    @PostMapping("/users")
    int addUser(@RequestBody AuthUser user) {
        return authUserService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    int deleteUser(@PathVariable("id") int id) {
        return authUserService.deleteUser(id);
    }

    @PutMapping("/users")
    int editUser(@RequestBody AuthUser user) {
        return authUserService.editUser(user);
    }

}
