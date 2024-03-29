create table `image_scan_steps`
(
    id                bigint AUTO_INCREMENT PRIMARY KEY comment '主键',
    pj_id             bigint DEFAULT 123456 comment '项目id',
    type_option       int           DEFAULT 0 NOT NULL comment '项目类型',
    status            int           DEFAULT 0 NOT NULL comment 'step status',
    step              int           DEFAULT 0 NOT NULL comment 'current step',
    stage             varchar(128)  DEFAULT 'check' NOT NULL comment 'define stage',
    logs              MEDIUMTEXT comment 'log',
    time_stamp         TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    FOREIGN KEY(pj_id) REFERENCES image_scan_job(pj_id)
);
