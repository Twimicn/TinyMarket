package cn.ivanlu.market.model;

import lombok.Data;

import java.util.Date;

@Data
public class Shipping {
    private long id;
    private long userId;
    private String receiverName;
    private String receiverPhone;
    private String receiverMobile;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    private Date createTime;
    private Date updateTime;
}
