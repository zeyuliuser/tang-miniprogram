package com.tang.tangminiprogram.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class UserPO {
    @TableId(type = IdType.UUID)
    private String id;
    private String username;
    private String mobilephone;
    private Date createTime;
    private int level;
}
