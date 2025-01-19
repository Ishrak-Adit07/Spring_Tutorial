CREATE TABLE course (
                        id BIGINT PRIMARY KEY,                      -- Unique identifier for each course
                        name VARCHAR(100) NOT NULL,                 -- Name of the course (up to 100 characters)
                        author VARCHAR(100) NOT NULL,               -- Author of the course (up to 100 characters)
                        CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Timestamp of when the course was created
);

INSERT INTO course (id, name, author)
VALUES (1, 'Introduction to SQL', 'John Doe');

INSERT INTO course (id, name, author)
VALUES
    (2, 'Advanced Java', 'Jane Smith'),
    (3, 'Python for Data Science', 'Alice Johnson'),
    (4, 'Web Development Basics', 'Bob Brown'),
    (5, 'Web Basics', 'Steve Brown');
