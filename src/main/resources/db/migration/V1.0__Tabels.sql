CREATE TABLE IF NOT EXISTS users
(
    id        uuid DEFAULT uuid_generate_v4(),
    parent    uuid,
    name      CHARACTER VARYING NOT NULL,
    role      CHARACTER VARYING NOT NULL,
    net_worth NUMERIC           NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT parent_fk FOREIGN KEY (parent) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tickets
(
    id          uuid DEFAULT uuid_generate_v4() NOT NULL,
    reporter    uuid                            NOT NULL,
    assignee    uuid,
    description CHARACTER VARYING,
    title       CHARACTER VARYING               NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT reporter_fk FOREIGN KEY (reporter) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT assignee_fk FOREIGN KEY (assignee) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS comments
(
    id         uuid DEFAULT uuid_generate_v4() NOT NULL,
    ticket     uuid                            NOT NULL,
    author     uuid,
    content    CHARACTER VARYING               NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE        NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT reporter_fk FOREIGN KEY (ticket) REFERENCES tickets (id) ON DELETE CASCADE,
    CONSTRAINT assignee_fk FOREIGN KEY (author) REFERENCES users (id) ON DELETE CASCADE
);
