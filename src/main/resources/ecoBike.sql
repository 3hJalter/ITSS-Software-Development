
-- Table structure for table user

DROP TABLE IF EXISTS "customer";
CREATE TABLE "customer" (
  id SERIAL PRIMARY KEY,
  username varchar(16) NOT NULL,
  email varchar(255) NOT NULL,
  create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  phone varchar(11) NOT NULL,
  CONSTRAINT user_phone_uindex UNIQUE (phone),
  CONSTRAINT user_email_uindex UNIQUE (email)
);

-- Dumping data for table user

INSERT INTO "customer" VALUES (1,'tandb','tandb@gmail.com','2022-01-04 17:38:28','0123456789'),(2,'longnd','longnd@gmail.com','2022-01-04 17:38:28','0213456789'),(3,'khanhdn','khanhdn@gmail.com','2022-01-04 17:38:28','0312456789');



-- Table structure for table category

DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id SERIAL PRIMARY KEY,
  name varchar(255) NOT NULL,
  costs_per_hour float DEFAULT NULL,
  n_seats int DEFAULT NULL,
  n_pedals int DEFAULT NULL
);

-- Dumping data for table category

INSERT INTO category VALUES (2,'Xe Đạp Thường',12000,2,1),(3,'Xe Đạp Đôi',18000,3,2),(4,'Xe Đạp Điện',18000,2,0),(5,'Xe Đạp Đôi Điện',24000,3,0);

-- Table structure for table station

DROP TABLE IF EXISTS station;
CREATE TABLE station (
  id SERIAL PRIMARY KEY,
  station_name varchar(255) NOT NULL,
  image_path varchar(255) NOT NULL,
  address varchar(255) NOT NULL
);

-- Dumping data for table station

INSERT INTO station VALUES (1,'eco blue','/','số 1 trần duy hưng'),(2,'eco green','/','số 1 trần đại nghĩa'),(3,'eco red','/','số 1 nguyễn trãi'),(4,'eco yellow','/','số 1 đại cồ việt'),(5,'eco pink','/','số 3 nguyễn hùng'),(6,'eco white','/','số 5 giếng mứt'),(7,'eco black','/','số 15 tôn thất tùng');

-- Table structure for table transaction

DROP TABLE IF EXISTS transaction;
CREATE TABLE transaction (
  transaction_id SERIAL PRIMARY KEY,
  total_payment float DEFAULT NULL,
  rented_duration float DEFAULT NULL,
  user_id int NOT NULL,
  content varchar(45) DEFAULT NULL,
  CONSTRAINT fk_transaction_user1 FOREIGN KEY (user_id) REFERENCES "customer" (id)
);


-- Table structure for table bike

DROP TABLE IF EXISTS bike;
CREATE TABLE bike (
  id SERIAL PRIMARY KEY,
  bike_name varchar(255) NOT NULL,
  pin float DEFAULT NULL,
  status boolean NOT NULL,
  category_id int NOT NULL,
  station_id int NOT NULL,
  fees int DEFAULT NULL,
  image_path varchar(55) DEFAULT NULL,
  CONSTRAINT fk_bike_category1 FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT fk_bike_station1 FOREIGN KEY (station_id) REFERENCES station (id)
);

-- Dumping data for table bike

INSERT INTO bike VALUES (1,'xe đạp mini thống nhất',NULL,FALSE,2,3,400000,'xe1.jpg'),(2,'xe đạp đôi g3c yamaha',NULL,TRUE,3,1,550000,'xe2.jpg'),(3,'xe đạp điện suzuki',80,TRUE,4,1,700000,'xe3.jpg'),(4,'xe đạp hitasa',NULL,TRUE,2,1,400000,'xe4.jpg'),(5,'xe đạp điện đôi honda',90,TRUE,5,2,800000,'xe5.jpg'),(6,'xe đạp đôi honda',NULL,TRUE,3,1,550000,'xe6.jpg'),(7,'xe đạp mini nhật maruishi',NULL,TRUE,2,3,400000,'xe7.jpg'),(8,'xe đạp thường trumix',NULL,TRUE,2,1,400000,'xe8.jpg'),(9,'xe đạp điện nakxus',75,TRUE,3,5,700000,'xe9.jpg'),(10,'xe đạp mini ',NULL,TRUE,2,6,400000,'xe10.jpg'),(11,'xe đạp đôi mec',NULL,TRUE,3,7,700000,'xe11.jpg'),(12,'xe đạp điện ninja',65,TRUE,4,4,550000,'xe12.jpg');

