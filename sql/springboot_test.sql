CREATE TABLE `sys_user`
(
    `id`          bigint NOT NULL,
    `username`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `password`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `email`       varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `address`     varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_time` datetime                                DEFAULT NULL,
    `create_id`   bigint                                  DEFAULT NULL,
    `update_id`   bigint                                  DEFAULT NULL,
    `update_time` datetime                                DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;