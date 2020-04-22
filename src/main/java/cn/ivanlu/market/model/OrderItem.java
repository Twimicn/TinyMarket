package cn.ivanlu.market.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItem {
    private long id;
    private long userId;
    private long productId;
    private String orderNo;
    private String productName;
    private String productImage;
    private BigDecimal currentUnitPrice;
    private int quantity;
    private BigDecimal totalPrice;
    private Date createTime;
    private Date updateTime;
}
