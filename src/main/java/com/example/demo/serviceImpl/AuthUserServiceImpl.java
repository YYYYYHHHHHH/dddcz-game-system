package com.example.demo.serviceImpl;

import java.util.List;

import com.example.demo.dao.AuthUserDao;
import com.example.demo.entity.AuthUser;
import com.example.demo.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserDao dao;

    @Override
    public List<AuthUser> getUsers() {
        return dao.queryAll(new AuthUser());
    }

    @Override
    public int addUser(AuthUser user) {
        return dao.insert(user);
    }

    @Override
    public int deleteUser(int id) {
        return dao.deleteById(id);
    }

    @Override
    public int editUser(AuthUser user) {
        return dao.update(user);
    }

    @Override
    public boolean login(AuthUser user) {
        return dao.queryAll(user).size() == 0 ? false : true;
    }
}
