CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Insertion des utilisateurs initiaux
INSERT INTO users (username, password, role) VALUES
(
  'admin',
  '$2a$10$KQ9s9Y5n9cBzEJ8cQe3pCe4pWZxL1qJ9c9F0r1u6A3P8y8e9J8N4G',
  'ADMIN'
),
(
  'patient',
  '$2a$10$Z8dKqL5nVQe9A8J9F2cPZ1u8e4L9q7rS5A6KJ0X3QeC1p8n9YB7W',
  'PATIENT'
);