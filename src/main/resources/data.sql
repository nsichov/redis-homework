DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
  id INT PRIMARY KEY,
  channel VARCHAR(250) NOT NULL,
  text VARCHAR(250) NOT NULL,
  timestamp BIGINT NOT NULL
);

INSERT INTO messages VALUES (1, 'test', 'first test', 1546616304000), (2, 'test', 'second test', 1578152304000), (3, 'test', 'third test', 1609774804000);
