INSERT INTO Reservations(Room, Name, Adults, Children, StartDate, EndDate, TotalRoomCost)
VALUES
(308,'Mack Simmer',1,0,'2023/02/02','2023/02/04','$299.98'),
(203,'Bettyann Seery',2,1,'2023/02/05','2023/02/10','$999.95'),
(305,'Duane Cullison',2,0,'2023/02/22','2023/02/24','$349.98'),
(201,'Karie Yang',2,2,'2023/03/06','2023/03/07','$199.99'),
(307,'Your Name',1,1,'2023/03/17','2023/03/20','$524.97'),
(302,'Aurore Lipton',3,0,'2023/03/18','2023/03/23','$924.95'),
(202,'Zachery Luechtefeld',2,2,'2023/03/29','2023/03/31','$349.98'),
(304,'Jeremiah Pendergrass',2,0,'2023/03/31','2023/04/05','$874.95'),
(301,'Walter Holaway',1,0,'2023/04/09','2023/04/13','$799.96'),
(207,'Wilfred Vise',1,1,'2023/04/23','2023/04/24','$174.99'),
(401,'Maritza Tilton',2,4,'2023/05/30','2023/06/02','$1199.97'),
(206,'Joleen Tison',2,0,'2023/06/10','2023/06/14','$599.96'),
(208,'Joleen Tison',1,0,'2023/06/10','2023/06/14','$599.96'),
(304,'Aurore Lipton',3,0,'2023/06/17','2023/06/18','$184.99'),
(205,'Your Name',2,0,'2023/06/28','2023/07/02','$699.96'),
(204,'Walter Holaway',3,1,'2023/07/13','2023/07/14','$184.99'),
(401,'Wilfred Vise',4,2,'2023/07/18','2023/07/21','$1259.97'),
(303,'Bettyann Seery',2,1,'2023/07/28','2023/07/29','$199.99'),
(305,'Bettyann Seery',1,0,'2023/08/30','2023/09/01','$349.98'),
(208,'Mack Simmer',2,0,'2023/09/16','2023/09/17','$149.99'),
(203,'Karie Yang',2,2,'2023/09/13','2023/09/15','$399.98'),
(401,'Duane Cullison',2,2,'2023/11/22','2023/11/25','$1199.97'),
(206,'Mack Simmer',2,0,'2023/11/22','2023/11/25','$449.97'),
(301,'Mack Simmer',2,2,'2023/11/22','2023/11/25','$599.97'),
(302,'Maritza Tilton',2,0,'2023/12/24','2023/12/28','$699.96');

INSERT INTO Guests (Name, Address, City, State, Zip, Phone) 
VALUES
('Michael Louissaint', '123 Road', 'Austin', 'TX', '78759', '(555) 555-5555'), 
('Mack Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '(291) 553-0508'), 
('Bettyann Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654','(478) 277-9632'),
('Duane Cullison', '9662 Foxrun Lane', 'Harlingen','TX', '78552', '(308) 494-0198'),
('Karie Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '(214) 730-0298'),
('Aurore Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '(377) 507-0974'),
('Zachery Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003', '(814) 485-2615'),
('Jeremiah Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '(279) 491-0960'),
('Walter Holaway', '7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '(446) 396-6785'),
('Wilfred Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '(834) 727-1001'),
('Maritza Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '(446) 351-6860'),
('Joleen Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '(231) 893-2755');

ALTER TABLE `Room`
ADD CONSTRAINT `fk_AmenitiesID` FOREIGN KEY (`AmenitiesID`) REFERENCES `Amenities`
(`AmenitiesID`) ON DELETE NO ACTION;

ALTER TABLE `Amenities`
ADD CONSTRAINT `fk_RoomID` FOREIGN KEY (`RoomID`) REFERENCES `Room`
(`RoomID`) ON DELETE NO ACTION;

ALTER TABLE `ReservationList`
ADD CONSTRAINT `fk_ReservationID` FOREIGN KEY (`ReservationID`) REFERENCES `Reservations`
(`ReservationID`) ON DELETE NO ACTION;
