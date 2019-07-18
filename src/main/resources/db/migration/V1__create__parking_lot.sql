CREATE TABLE `parking_lot`(
    `id` varchar (255) primary key,
    `name` varchar (255) unique ,
    `capacity` int,
    `address` varchar (255),
    `parking_order_id` int,
    `car_id` varchar (255)
)