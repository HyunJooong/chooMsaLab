CREATE TABLE products
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY,
    category_id BIGINT       NOT NULL,
    name        VARCHAR(200) NOT NULL,
    price       NUMERIC      NOT NULL,
    description TEXT,
    stock       INT          NOT NULL,
    created_at  TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ  NOT NULL DEFAULT NOW(),

    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    name       VARCHAR(50)  NOT NULL,
    phone      VARCHAR(20),
    role       VARCHAR(20)  NOT NULL DEFAULT 'BUYER',
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),

    PRIMARY KEY (id),
    CONSTRAINT uq_users_email UNIQUE (email)
);

CREATE TABLE categories
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY,
    parent_id   BIGINT,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    created_at  TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),

    PRIMARY KEY (id)
);

