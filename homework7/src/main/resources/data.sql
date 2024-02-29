DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(45)  NOT NULL,
    phone      varchar(15)  NOT NULL UNIQUE,
    role       varchar(45)  NOT NULL,
    login      varchar(45)  NOT NULL UNIQUE,
    password   varchar(100) NOT NULL
);

INSERT INTO users (first_name, phone, role, login, password)
VALUES ('Petr', '+71234567890', 'USER', 'user1', '$2a$10$yBU1YiYFQ4FhuCb14iCXC.D3SmOrD9Y/Cl/VrLsKUrh2mHlU1cKAG');

INSERT INTO users (first_name, phone, role, login, password)
VALUES ('Elena', '+773651947264', 'ADMIN', 'user2', '$2a$10$oxuZ/1qOr1cfgcTnej7lhuwJZ81l8VXlPG0scK1s9BqUkMW1h08YK');