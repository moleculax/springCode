DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;


CREATE TABLE departments (
                             id INTEGER PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
                           id INTEGER PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) UNIQUE NOT NULL,
                           department_id INTEGER NOT NULL,
                           FOREIGN KEY (department_id) REFERENCES departments(id)
);

INSERT INTO departments (name) VALUES ('Cervezas');
INSERT INTO departments (name) VALUES ('Asados');
INSERT INTO departments (name) VALUES ('Vinos');

INSERT INTO employees (name, email, department_id) VALUES ('Pepe Lepon', 'pepe@mail.com', 1);
INSERT INTO employees (name, email, department_id) VALUES ('Conor Lepon', 'conor@mail.com', 1);
INSERT INTO employees (name, email, department_id) VALUES ('Kamaru Lepon', 'kamaru@mail.com', 2);
INSERT INTO employees (name, email, department_id) VALUES ('Jorge Lepon', 'jorge@mail.com', 2);
INSERT INTO employees (name, email, department_id) VALUES ('Francis Lepon', 'francis@mail.com', 3);
INSERT INTO employees (name, email, department_id) VALUES ('Lupe Lepon', 'Lupe@mail.com', 3);