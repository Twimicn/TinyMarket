package cn.ivanlu.market.model;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private long id;
    private long parentId;
    private String name;
    private boolean status;
    private int sortOrder;
    private Date createTime;
    private Date updateTime;

    public Category() {

    }

    public Category(long id, long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}
