ALTER TABLE tasks
ADD COLUMN client UUID REFERENCES clients(client_id)