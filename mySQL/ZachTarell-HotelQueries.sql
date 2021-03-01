-- 1. Write a query that returns a list of reservations that end in July 2023,
-- including the name of the guest, the room number(s), and the reservation dates.

select Room, Name, startDate, EndDate 
FROM Reservations
WHERE (EndDate <= DATE'2023-07-31' AND EndDate >= DATE'2023-07-01'); 

-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi,
-- displaying the guest's name, the room number, and the dates of the reservation.

SELECT Name, Room, StartDate, EndDate
FROM Reservations
WHERE (Room % 2 = 1) AND (Room < '400');

-- 3. Write a query that returns all the rooms reserved for a specific guest, including the guest's name,
-- the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation.
-- (Choose a guest's name from the existing data.)

SELECT room, name, startDate, (adults + children) AS totalGuests
FROM Reservations
WHERE (Name = 'Mack Simmer');

-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation.
-- The results should include all rooms, whether or not there is a reservation associated with the room.

SELECT room, reservationID, TotalRoomCost AS costPerRoom
FROM reservations
ORDER BY room;

-- 5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April 2023.

SELECT Room
FROM Reservations
WHERE ((Adults+Children) <= 3 AND (Adults+Children) >= 1)
AND (StartDate <= DATE'2023-04-30' AND StartDate >= DATE'2023-04-01');

-- 6. Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest
-- with the most reservations and then by the guest's last name.

SELECT Name, count(Name) AS numOfGuests
FROM Reservations
GROUP BY Name
ORDER BY StartDate ASC;

-- 7. Write a query that displays the name, address, and phone number of a guest based on their phone number.
-- (Choose a phone number from the existing data.)

SELECT Name, Address, Phone
FROM Guests
WHERE (Phone = '(214) 730-0298');
