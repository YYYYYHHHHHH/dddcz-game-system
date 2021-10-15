package com.example.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息(AuthUser)实体类
 *
 * @author makejava
 * @since 2021-10-15 11:20:57
 */
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 220118574300357221L;
    /**
    * 用户ID
    */
    private Integer id;
    /**
    * 用户代码
    */
    private String code;
    /**
    * 用户名 用于登录
    */
    private String name;
    /**
    * 密码
    */
    private String password;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * 头像图片地址
    */
    private String avatar;
    /**
    * 个性签名
    */
    private String sign;
    /**
    * 手机号码
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 创建时间
    */
    private Date createdTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}