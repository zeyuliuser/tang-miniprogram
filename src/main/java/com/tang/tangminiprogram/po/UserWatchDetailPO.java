package com.tang.tangminiprogram.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_watch_detail")
public class UserWatchDetailPO {
    @TableId(type = IdType.UUID)
    private String id;
    private String userId;
    private String productId;
    private Date clickTime;
}
