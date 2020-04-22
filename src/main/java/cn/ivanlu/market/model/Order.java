package cn.ivanlu.market.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private long id;
    private String orderNo;
    private long userId;
    private long shippingId;
    private BigDecimal payment;
    private int paymentType;
    private int postage;
    private int status;
    private Date paymentTime;
    private Date sendTime;
    private Date endTime;
    private Date closeTime;
    private Date createTime;
    private Date updateTime;
}
