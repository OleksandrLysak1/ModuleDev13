DELETE FROM TICKET;
DELETE FROM CLIENT;
DELETE FROM PLANET;

INSERT INTO PLANET (id, name) VALUES
('MARS', 'Mars'),
('VEN', 'Venus'),
('EARTH', 'Earth'),
('JUPITER', 'Jupiter'),
('SATURN', 'Saturn');

INSERT INTO CLIENT (id, name) VALUES
(1, 'John Doe'),
(2, 'Jane Smith'),
(3, 'Emily Johnson'),
(4, 'Michael Brown'),
(5, 'Jessica Davis'),
(6, 'Daniel Wilson'),
(7, 'Laura Garcia'),
(8, 'James Miller'),
(9, 'Emma Rodriguez'),
(10, 'William Martinez');

INSERT INTO TICKET (id, created_at, client_id, from_planet_id, to_planet_id) VALUES
(1, NOW(), 1, 'MARS', 'VEN'),
(2, NOW(), 2, 'EARTH', 'JUPITER'),
(3, NOW(), 3, 'VEN', 'SATURN'),
(4, NOW(), 4, 'MARS', 'EARTH'),
(5, NOW(), 5, 'JUPITER', 'VEN'),
(6, NOW(), 6, 'SATURN', 'MARS'),
(7, NOW(), 7, 'EARTH', 'JUPITER'),
(8, NOW(), 8, 'VEN', 'MARS'),
(9, NOW(), 9, 'JUPITER', 'EARTH'),
(10, NOW(), 10, 'SATURN', 'VEN');
