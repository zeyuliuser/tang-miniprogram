package com.tang.tangminiprogram.request;

import lombok.Data;

@Data
public class UserPageReq  {
    private Long current;
    private Long size;
    private Long limit;
}
