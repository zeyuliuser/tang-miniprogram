package com.tang.tangminiprogram.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("stone_class")
public class StoneClassPO {
    @TableId(type = IdType.UUID)
    private String id;
    private Date createTime;
    private String classInfo;
    private int classLevel;
}
