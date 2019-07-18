create TABLE `parking_order`(
     `id`             varchar(255) PRIMARY KEY,
    `parking_name` VARCHAR(255) NOT NULL,
    `CAR_NUMBER`       VARCHAR(255) NOT NULL,
    `create_date`      DATETIME     NOT NULL,
    `fetch_date`       DATETIME,
    `PARKING_LOT_ID`  varchar (255),
    `ORDER_STATUS`           BOOLEAN      NOT NULL
)