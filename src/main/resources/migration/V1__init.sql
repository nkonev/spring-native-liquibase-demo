CREATE TABLE user_native (
                       id bigserial PRIMARY KEY,
                       username character varying(50) UNIQUE NOT NULL,
                       password character varying(100),
                       avatar character varying(256),
                       enabled boolean DEFAULT true NOT NULL,
                       expired boolean DEFAULT false NOT NULL,
                       locked boolean DEFAULT false NOT NULL,
                       email character varying(100) UNIQUE,
                       last_login_date_time timestamp without time zone
);


-- insert test data
INSERT INTO user_native(username, password, avatar, email) VALUES
                                                         ('nikita', '$2a$10$e3pEnL2d3RB7jBrlEA3B9eUhayb/bmEG1V35h.4EhdReUAMzlAWxS', '/654853-user-men-2-512.png', 'nikita@example.com'), -- bcrypt('password', 10)
                                                         ('alice', '$2a$10$e3pEnL2d3RB7jBrlEA3B9eUhayb/bmEG1V35h.4EhdReUAMzlAWxS', '/girl-512.png', 'alice@example.com'),
                                                         ('bob', '$2a$10$e3pEnL2d3RB7jBrlEA3B9eUhayb/bmEG1V35h.4EhdReUAMzlAWxS', NULL, 'bob@example.com'),
                                                         ('John Smith', '$2a$10$e3pEnL2d3RB7jBrlEA3B9eUhayb/bmEG1V35h.4EhdReUAMzlAWxS', NULL, 'jsmith@example.com')
;
-- insert many test users
INSERT INTO user_native (username, password, avatar, email)
SELECT
        'generated_user_' || i,
        '$2a$10$0nGRZ4Quy0hW2W.prjc.AOyUkNqgFulVckZQ.gFsOly5ESntrW7E.', -- bcrypt('generated_user_password', 10)
        CASE
            WHEN i % 2 = 0 THEN '/Avatar_Alien-512.png'
            ELSE NULL
            END,
        'generated' || i || '@example.com'
FROM generate_series(0, 1000) AS i;
