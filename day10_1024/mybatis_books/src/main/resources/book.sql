USE testdb;

SHOW TABLES;

CREATE TABLE book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	author VARCHAR(200) NOT NULL,
	price INT NOT NULL CHECK (price >= 0),
	stock INT NOT NULL DEFAULT 0 CHECK (stock >= 0),
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO book (title, author, price, stock) VALUES
	('이펙티브 자바 3/E', '조슈아 블로크', 42000, 10),
	('클린 코드', '로버트 c.마틴', 38000, 8),
	('스프링 인 액션  6/E', '크레이그 월즈', 45000, 12);

SELECT * from book ORDER BY id DESC;

SELECT * FROM book WHERE id = 1;

UPDATE book
SET title = '영희 책', author = '김영희', price = 25000, stock = 8
WHERE id = 4;

DELETE FROM book
WHERE id = 4;