CREATE TABLE notes
(
    id      SERIAL PRIMARY KEY,
    title   varchar NOT NULL,
    content varchar NOT NULL,
    created timestamp
)
