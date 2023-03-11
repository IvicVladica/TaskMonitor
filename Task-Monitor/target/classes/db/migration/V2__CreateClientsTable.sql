CREATE TABLE if not exists clients (
  client_id UUID PRIMARY KEY,
  name varchar (250),
  address varchar (250),
  phone varchar (50),
  priority varchar (20)
);