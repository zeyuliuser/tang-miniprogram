package com.tang.tangminiprogram.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("product")
@Data
public class ProductPO {
    @TableId(type = IdType.UUID)
    private String id;
    private String stoneClassId;
    private String color;
    private String description;
    private Date createTime;
}
