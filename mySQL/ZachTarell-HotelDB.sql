DROP DATABASE IF EXISTS ZachTarell_HotelDB;

CREATE DATABASE ZachTarell_HotelDB;

USE ZachTarell_HotelDB;

CREATE TABLE IF NOT EXISTS Room
(
	`RoomID` INT NOT NULL AUTO_INCREMENT,
    `Room` INT NOT NULL,
    `roomType` VARCHAR(15) NOT NULL,
    `AmenitiesID` INT,
    `ADA_Accessible` BOOL,
    `Standard_Occupancy` VARCHAR(255),
    `Maximum_Occupancy` VARCHAR(255),
    `Base_Price` VARCHAR(255),
    `Extra_Person` VARCHAR(255),
    PRIMARY KEY (`RoomID`)
);

CREATE TABLE IF NOT EXISTS Reservations
(
    `ReservationID` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(255),
    `Room` INT NOT NULL,
    `Adults` INT,
    `Children` INT,
    `StartDate` DATE,
    `EndDate` DATE,
    `TotalRoomCost` VARCHAR(255),
    PRIMARY KEY (`ReservationID`)
);

CREATE TABLE IF NOT EXISTS Guests
(
	`GuestID` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(100),
    `Address` VARCHAR(130),
    `City` VARCHAR(255),
    `State` VARCHAR(255),
    `Zip` VARCHAR(5),
    `Phone` VARCHAR(14),
    PRIMARY KEY (`GuestID`)
);

CREATE TABLE IF NOT EXISTS Amenities
(
    `AmenitiesID` INT NOT NULL AUTO_INCREMENT,
    `Type` VARCHAR(255),
    `RoomID` INT,
    PRIMARY KEY (`AmenitiesID`)
);

CREATE TABLE IF NOT EXISTS RoomList
(
    `AmenitiesID` INT,
    `RoomID` INT
);

CREATE TABLE IF NOT EXISTS ReservationList
(
    `RoomID` INT,
    `ReservationID` INT,
    PRIMARY KEY (`RoomID`)
);

INSERT INTO Room(Room, roomType, AmenitiesID, ADA_Accessible, Standard_Occupancy, Maximum_Occupancy, Base_Price, Extra_Person)
VALUES 
(201, 'Double', null, true, 2, 4, '$199.99', '$10'),
(202, 'Double', null, false, 2, 4, '$174.99', '$10'),
(203, 'Double', null, false, 2, 4, '$199.99', '$10'),
(204, 'Double', null, true, 2, 4, '$174.99', '$10'),
(205, 'Single', null, false, 2, 2, '$174.99', 'NA'),
(206, 'Single', null, true, 2, 2, '$149.99', 'NA'),
(207, 'Single', null, false, 2, 2, '$174.99', 'NA'),
(208, 'Single', null, true, 2, 2, '$149.99', 'NA'),
(301, 'Double', null, false, 2, 4, '$199.99', '$10'),
(302, 'Double', null, true, 2, 4, '$174.99', '$10'),
(303, 'Double', null, false, 2, 4, '$199.99', '$10'),
(304, 'Double', null, true, 2, 4, '$174.99', '$10'),
(305, 'Single', null, false, 2, 2, '$174.99', 'NA'),
(306, 'Single', null, true, 2, 2, '$149.99', 'NA'),
(307, 'Single', null, false, 2, 2, '$174.99', 'NA'),
(308, 'Single', null, true, 2, 2, '$149.99', 'NA'),
(401, 'Suite', null, true, 3, 8, '$399.99', '$20'),
(402, 'Suite', null, true, 3, 8, '$399.99', '$20');

-- I got stuck trying to populate the Amenities, but every time I did it would mess up the ALTER TABLE.
-- I didn't know hw to fix that part, so left it as null and integer.
-- If I had to guess, it would be to populate the Amenities inside the Amenities table, maybe...
-- and call that integer to populate the type of Amenities inside of the room table, somehow.

-- (201, 'Double', 'Microwave, Jacuzzi', true, 2, 4, '$199.99', '$10'),
-- (202, 'Double', 'Refrigerator', false, 2, 4, '$174.99', '$10'),
-- (203, 'Double', 'Microwave, Jacuzzi', false, 2, 4, '$199.99', '$10'),
-- (204, 'Double', 'Refrigerator', true, 2, 4, '$174.99', '$10'),
-- (205, 'Single', 'Microwave, Refrigerator, Jacuzzi', false, 2, 2, '$174.99', 'NA'),
-- (206, 'Single', 'Microwave, Refrigerator', true, 2, 2, '$149.99', 'NA'),
-- (207, 'Single', 'Microwave, Refrigerator, Jacuzzi', false, 2, 2, '$174.99', 'NA'),
-- (208, 'Single', 'Microwave, Refrigerator', true, 2, 2, '$149.99', 'NA'),
-- (301, 'Double', 'Microwave, Jacuzzi', false, 2, 4, '$199.99', '$10'),
-- (302, 'Double', 'Refrigerator', true, 2, 4, '$174.99', '$10'),
-- (303, 'Double', 'Microwave, Jacuzzi', false, 2, 4, '$199.99', '$10'),
-- (304, 'Double', 'Refrigerator', true, 2, 4, '$174.99', '$10'),
-- (305, 'Single', 'Microwave, Refrigerator, Jacuzzi', false, 2, 2, '$174.99', 'NA'),
-- (306, 'Single', 'Microwave, Refrigerator', true, 2, 2, '$149.99', 'NA'),
-- (307, 'Single', 'Microwave, Refrigerator, Jacuzzi', false, 2, 2, '$174.99', 'NA'),
-- (308, 'Single', 'Microwave, Refrigerator', true, 2, 2, '$149.99', 'NA'),
-- (401, 'Suite', 'Microwave, Refrigerator, Oven', true, 3, 8, '$399.99', '$20'),
-- (402, 'Suite', 'Microwave, Refrigerator, Oven', true, 3, 8, '$399.99', '$20');