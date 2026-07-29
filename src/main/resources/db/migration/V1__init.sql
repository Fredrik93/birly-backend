CREATE TABLE billboard_item (
    id          character varying(255) NOT NULL,
    created_at  timestamp(6) with time zone,
    created_by_user character varying(255),
    description character varying(255),
    title       character varying(255),
    housing_association     character varying(255),
    CONSTRAINT billboard_item_pkey PRIMARY KEY (id)
);
