package cn.ivanlu.market.model;

import lombok.Data;

import java.util.Date;

@Data
public class PayInfo {
    private long id;
    private long userId;
    private String orderNo;
    private int payPlatform;
    private String platformNumber;
    private String platformStatus;
    private Date createTime;
    private Date updateTime;
}
