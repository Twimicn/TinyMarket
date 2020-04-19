package cn.ivanlu.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private int roleId;
    private Date createTime;
    private Date updateTime;
    private String token;
    private Date expire;

    public User() {

    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createTime = new Date();
        this.roleId = 0;
    }
}
