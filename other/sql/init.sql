CREATE TABLE `t_student`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `age`         int                                     DEFAULT NULL,
    `address`     varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_time` datetime                                default null,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `t_stu_sex`
(
    `id`     int NOT NULL AUTO_INCREMENT,
    `sex`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `stu_id` int                                     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

