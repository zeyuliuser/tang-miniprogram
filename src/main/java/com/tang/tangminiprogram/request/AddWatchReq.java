package com.tang.tangminiprogram.request;

import com.tang.tangminiprogram.po.UserPO;
import com.tang.tangminiprogram.po.UserWatchDetailPO;
import lombok.Data;

@Data
public class AddWatchReq {
    private UserPO userPO;
    private UserWatchDetailPO userWatchDetailPO;
}
