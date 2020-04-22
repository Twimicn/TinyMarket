package cn.ivanlu.market.model;

import lombok.Data;

import java.util.Date;

@Data
public class Cart {
    private long id;
    private long userId;
    private long productId;
    private int quantity;
    private int checked;
    private Date createTime;
    private Date updateTime;

    public Cart() {

    }

    public Cart(long id, long userId, long productId, int quantity, int checked) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.checked = checked;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
