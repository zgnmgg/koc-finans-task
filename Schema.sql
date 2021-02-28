CREATE TABLE IF NOT EXISTS user_score (
    identity_number varchar(11) NOT NULL,
    phone varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    city varchar(255) NOT NULL,
    score int
);

ALTER TABLE ONLY user_score ADD CONSTRAINT user_score_pkey PRIMARY KEY (identity_number);

CREATE TABLE IF NOT EXISTS income (
    code int NOT NULL,
    multipler int NOT NULL,
    description varchar(255) NOT NULL
);

ALTER TABLE ONLY income ADD CONSTRAINT income_pkey PRIMARY KEY (code);

INSERT INTO income ("code", "multipler", "description") values (1, 800, '0-2999TL');
INSERT INTO income ("code", "multipler", "description") values (2, 1000, '3000TL-4999TL');
INSERT INTO income ("code", "multipler", "description") values (3, 1200, '5000TL-7999TL');
INSERT INTO income ("code", "multipler", "description") values (4, 1500, '8000TL-11999TL');
INSERT INTO income ("code", "multipler", "description") values (5, 2000, '12000TL ve üzeri');