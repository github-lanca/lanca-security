CREATE TABLE `sys_user`
(
    `id`          bigint NOT NULL,
    `username`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `phone`       varchar(255) COLLATE utf8mb4_general_ci                       DEFAULT NULL,
    `email`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `address`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_time` datetime                                                      DEFAULT NULL,
    `create_id`   bigint                                                        DEFAULT NULL,
    `update_id`   bigint                                                        DEFAULT NULL,
    `update_time` datetime                                                      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

# -------------------------------------------------------------------
INSERT INTO `springboot_test`.`sys_user`(`id`, `username`, `password`, `phone`, `email`, `address`, `create_time`,
                                         `create_id`, `update_id`, `update_time`)
VALUES (1, 'admin', '1234', '15877778888', '908847427@qq.com', '北京市', '2022-03-01 09:38:47', 1, 1,
        '2022-03-02 09:38:54');
INSERT INTO `springboot_test`.`sys_user`(`id`, `username`, `password`, `phone`, `email`, `address`, `create_time`,
                                         `create_id`, `update_id`, `update_time`)
VALUES (2, 'zhangsan', '1234', '13988889999', '908847427@qq.com', '北京市', '2022-03-01 09:38:47', 1, 1,
        '2022-03-02 09:38:54');
