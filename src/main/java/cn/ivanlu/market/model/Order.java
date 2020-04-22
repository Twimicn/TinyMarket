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

    public Order() {

    }

    public Order(long id, String orderNo, long userId, long shippingId, BigDecimal payment, int paymentType, int postage, int status) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.shippingId = shippingId;
        this.payment = payment;
        this.paymentType = paymentType;
        this.postage = postage;
        this.status = status;
    }
}
