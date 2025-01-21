INSERT INTO user_details(id, birth_date, name)
VALUES (10001, CURRENT_DATE, 'Katniss');

INSERT INTO user_details(id, birth_date, name)
VALUES (10002, CURRENT_DATE, 'Emma');

INSERT INTO user_details(id, birth_date, name)
VALUES (10003, CURRENT_DATE, 'Peeta');

INSERT INTO post(id, user_id, description)
VALUES (20001, 10001, 'Could I be more sad?');

INSERT INTO post(id, user_id, description)
VALUES (20002, 10002, 'Could I be more sad?');

INSERT INTO post(id, user_id, description)
VALUES (20003, 10001, 'Could I be more sad?');

INSERT INTO post(id, user_id, description)
VALUES (20004, 10003, 'Could I be more sad?');

INSERT INTO post(id, user_id, description)
VALUES (20005, 10002, 'Could I be more sad?');