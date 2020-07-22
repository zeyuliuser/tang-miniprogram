drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(32) not null comment '主键id',
   username             varchar(255) not null comment '用户名',
   mobilephone          varchar(16) not null comment '用户手机',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table user comment '用户列表';

drop table if exists user_watch_detail;

/*==============================================================*/
/* Table: user_watch_detail                                       */
/*==============================================================*/
create table user_watch_detail
(
   id                   varchar(32) not null comment '主键id',
   user_id              varchar(32) comment '用户id',
   product_id           varchar(32) comment '产品id',
   click_time           datetime comment '浏览时间',
   primary key (id)
);
alter table user_watch_detail comment '浏览列表';

drop table if exists product;

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   id                   varchar(32) not null comment '主键id',
   stone_class_id       varchar(255) comment '石头类型id',
   color                varchar(255) comment '颜色',
   description          varchar(255) comment '描述',
   create_time          datetime comment '创建时间',
   primary key (id)
);
alter table product comment '产品列表';

drop table if exists stone_class;

/*==============================================================*/
/* Table: stone_class                                            */
/*==============================================================*/
create table stone_class
(
   id                   varchar(16) not null comment '主键id',
   class_info           varchar(255) comment '石头类型描述',
   create_time          datetime,
   class_level          int comment '列表等级',
   primary key (id)
);
alter table stone_class comment '石头类型列表';