-- users

INSERT INTO users(id, name, role, net_worth)
VALUES ('cbc8c74e-f0ad-4ccc-945d-6a28800c302a', 'Jon Snow', 'warrior', 100);
INSERT INTO users(id, name, role, net_worth)
VALUES ('b29c94c2-9e97-4137-874a-582f93b93657', 'Eddard Stark', 'politician', 5000);
INSERT INTO users(id, name, role, net_worth)
VALUES ('37b21c91-f5b8-4947-881c-52b7386376ea', 'Khal Drogo', 'warrior', 1);
INSERT INTO users(id, name, role, net_worth)
VALUES ('eb933347-0ffa-4f65-a111-89c50da3c781', 'Petyr Baelish', 'politician', 20000);
INSERT INTO users(id, name, role, net_worth)
VALUES ('8652f34b-7846-41b8-aa69-08053932f3a9', 'Tywin Lannister', 'politician', 2000000);
INSERT INTO users(id, parent, name, role, net_worth)
VALUES ('cd27aafb-577f-441c-a5a0-5a20256143cc', '8652f34b-7846-41b8-aa69-08053932f3a9', 'Jaime Lannister', 'warrior', 100000);
INSERT INTO users(id, parent, name, role, net_worth)
VALUES ('72abe3c8-5fac-4e70-835b-8ae29a03c2a6', 'cd27aafb-577f-441c-a5a0-5a20256143cc', 'Joffrey', 'politician', 0);

-- tickets

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('f7b8597a-9f0d-4591-894b-333ec73765b5', 'cbc8c74e-f0ad-4ccc-945d-6a28800c302a',
        'b29c94c2-9e97-4137-874a-582f93b93657', 'gift', 'Gimme Dog!');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('214bb7be-78f9-47db-b224-b257fa7a6ac0', 'b29c94c2-9e97-4137-874a-582f93b93657',
        'cd27aafb-577f-441c-a5a0-5a20256143cc', NULL, 'Defend the King!');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('933f3662-4e12-4eb0-a617-e2604d61ee4a', 'b29c94c2-9e97-4137-874a-582f93b93657',
        '37b21c91-f5b8-4947-881c-52b7386376ea', NULL, 'Defend the Eggs');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('896a6cd1-7e0d-4d5d-b076-f1ab18addb13', 'b29c94c2-9e97-4137-874a-582f93b93657',
        'cbc8c74e-f0ad-4ccc-945d-6a28800c302a', NULL, 'Defend the north');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('de34bd22-2baf-4ed3-8b0f-8476f3e000b3', 'cd27aafb-577f-441c-a5a0-5a20256143cc',
        NULL, NULL, 'Try to win a fight with me');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('c5595abe-df54-4dc5-b8ac-52f0f52df313', 'cd27aafb-577f-441c-a5a0-5a20256143cc',
        NULL, NULL, 'Try to win a fight with me');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('761ef8e1-9075-4ec6-85be-5c9b76774aab', 'b29c94c2-9e97-4137-874a-582f93b93657',
        NULL, NULL, 'Find Arya');

INSERT INTO tickets(id, reporter, assignee, description, title)
VALUES ('71b66391-8445-4c98-b434-e8800e68a07c', 'b29c94c2-9e97-4137-874a-582f93b93657',
        NULL, NULL, 'Defeat Joffrey');

-- comments

INSERT INTO comments(id, ticket, author, content, created_at)
VALUES ('670e036c-35f6-4b6d-8339-f983c03b47cd', '71b66391-8445-4c98-b434-e8800e68a07c',
        '37b21c91-f5b8-4947-881c-52b7386376ea', 'I can do it with wooden horse', '2024-04-02 19:10:25-07');

INSERT INTO comments(id, ticket, author, content, created_at)
VALUES ('eabd7218-f0d5-40f2-819d-98ed854a5f83', '71b66391-8445-4c98-b434-e8800e68a07c',
        'cbc8c74e-f0ad-4ccc-945d-6a28800c302a', 'EZ', '2024-04-03 19:10:25-07');

INSERT INTO comments(id, ticket, author, content, created_at)
VALUES ('a803a304-a98f-4b4a-92e4-aa2e0e69a726', '71b66391-8445-4c98-b434-e8800e68a07c',
        'cd27aafb-577f-441c-a5a0-5a20256143cc', 'Why?', '2024-04-04 19:10:25-07');

INSERT INTO comments(id, ticket, author, content, created_at)
VALUES ('57479666-8499-45f8-818c-a9c4831f8739', '933f3662-4e12-4eb0-a617-e2604d61ee4a',
        'cd27aafb-577f-441c-a5a0-5a20256143cc', 'Why?', '2024-04-05 19:10:25-07');

INSERT INTO comments(id, ticket, author, content, created_at)
VALUES ('f7b8597a-9f0d-4591-894b-333ec73765b5', '71b66391-8445-4c98-b434-e8800e68a07c',
        'cd27aafb-577f-441c-a5a0-5a20256143cc', 'Why?', '2024-04-06 19:10:25-07');
