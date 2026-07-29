CREATE TABLE users
(
    user_id             character varying(255) NOT NULL,
    housing_association character varying(255) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);