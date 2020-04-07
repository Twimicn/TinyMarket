package cn.ivanlu.market.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int roleId;
    private Date createTime;
    private Date updateTime;
}
