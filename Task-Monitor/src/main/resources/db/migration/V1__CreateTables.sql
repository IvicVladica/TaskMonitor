CREATE TABLE if not exists employees (
  employee_id UUID PRIMARY KEY,
  name varchar(100),
  email varchar(100),
  phone varchar(50),
  birth_date date,
  salary integer
);

CREATE TABLE if not exists tasks (
  task_id integer PRIMARY KEY,
  title varchar(250),
  description varchar(250),
  assignee UUID REFERENCES employees(employee_id)
);