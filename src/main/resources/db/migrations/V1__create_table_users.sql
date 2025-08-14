CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR(255) NOT NULL,
    role VARCHAR(100),
    phone VARCHAR(100),
    image_url TEXT,
    cep VARCHAR(20),
    hash TEXT,
    salt TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    price FLOAT
);