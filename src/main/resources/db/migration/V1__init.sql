CREATE TABLE IF NOT EXISTS billboard_item (
    id          uuid NOT NULL,
    created_at  timestamp(6) with time zone,
    created_by_user uuid,
    description character varying(255),
    title       character varying(255),
    housing_association     character varying(255),
    CONSTRAINT billboard_item_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    user_id             uuid NOT NULL,
    housing_association character varying(255) NOT NULL,
    apartment_number    character varying(255),
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);
