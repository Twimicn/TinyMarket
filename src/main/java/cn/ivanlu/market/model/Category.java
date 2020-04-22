package cn.ivanlu.market.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Category {
    private long id;
    private long parentId;
    private String name;
    private boolean status;
    private int sortOrder;
    private Date createTime;
    private Date updateTime;
}
