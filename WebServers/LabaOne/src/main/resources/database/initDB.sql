CREATE TABLE IF NOT EXISTS games
(
    id          BIGSERIAL       PRIMARY KEY,
    name        VARCHAR(100)    NOT NULL,
    studio_name VARCHAR(100)    NOT NULL,
    cost        DECIMAL         NOT NULL,
    photo       VARCHAR(200)    DEFAULT NULL,
    description VARCHAR(10000)  DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS key_for_game(
                                           key         BIGSERIAL       PRIMARY KEY,
                                           game_id     BIGINT          REFERENCES games(id),
                                           is_used     BOOLEAN         DEFAULT FALSE,
                                           key_holder  varchar(100)    DEFAULT NULL
);