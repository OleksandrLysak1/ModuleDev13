CREATE TABLE client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE PLANET (
    id VARCHAR(10) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$'), -- Лише великі латинські букви та цифри
    name VARCHAR(500) NOT NULL
);

CREATE TABLE ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT,
    from_planet_id VARCHAR(10),
    to_planet_id VARCHAR(10),
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
