CREATE TABLE customers (
    customerID INT NOT NULL,
    name CHAR(30) NOT NULL,
    phone CHAR(10),
    email CHAR(20),
    PRIMARY KEY (customerID)
);

CREATE TABLE room
(
	roomnumber int not null,
	type char(10),
	price decimal(8,2) not null default 1000,
	CHECK ( type in ('deluxe', 'luxury', 'suite') ),
	PRIMARY KEY (roomnumber)
);

CREATE TABLE reserve(
    booking INT NOT NULL,
    customerid INT,
    roomno INT,
    reserveDate DATE,
    checkinDate DATE,
    checkoutDate DATE,
    percentDiscount INT,
    PRIMARY KEY (booking),
    FOREIGN KEY (customerid) REFERENCES CUSTOMERS(customerID),
    FOREIGN KEY (roomno) REFERENCES ROOM(roomnumber),
    CHECK ( checkinDate < checkoutDate ),
    CHECK ( percentDiscount BETWEEN 0 AND 100)
);

INSERT INTO customers VALUES (111, 'John', '081111111', 'john@gmail.com');
INSERT INTO customers VALUES (112, 'Jack', '211111111', 'jack@gmail.com'),
                             (113, 'Stamp', 8888888888, 'stamp@microsoft.com');
INSERT INTO customers VALUES (114, 'Best Cruise', '9999999999', 'best@topgun2.com');

INSERT INTO room VALUES (2509, 'suite', 3000),
                        (2711, 'deluxe', 5000),
                        (1429, 'deluxe', 2000);

INSERT INTO reserve VALUES (33333, 114, 2711, '2020-07-20', '2020-08-15', '2020-08-17', 20)
