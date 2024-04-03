package com.dm4nk.unidb;

public class Queries {


    // window
    public static final String USER_WITH_AVERAGE_NET_WORTH = "SELECT name, role, net_worth, avg(net_worth) OVER (PARTITION BY role) as average_net_worth FROM users";

    // group by having
    // inner join
    public static final String TICKETS_WITH_N_COMMENTS = "select tickets.title from tickets inner join comments on comments.ticket = tickets.id group by tickets.id having count(comments.id) > {0}";

    // right join
    public static final String TICKETS_WITH_COMMENTS = "select comments.content as comment, tickets.title from comments right join tickets on comments.ticket = tickets.id";

    // left join
    public static final String TICKETS_WITH_COMMENTS_LEFT = "select tickets.title, comments.content as comment from tickets left join comments on comments.ticket = tickets.id";

    // full join
    public static final String USERS_WITH_COMMENTS = "select users.name, comments.content as comment from users full join comments on users.id = comments.author";

    // cross join
    public static final String POTENTIAL_OPPONENTS = "select op1.name as opponent1, op2.name as opponent2 from users op1 cross join users op2 where op1.name != op2.name";

    //with
    public static final String USERS_CHILDREN = "WITH RECURSIVE r AS (\n" +
            "   SELECT id, parent, name\n" +
            "   FROM users\n" +
            "   WHERE name = 'Tywin Lannister'\n" +
            "\n" +
            "   UNION\n" +
            "\n" +
            "   SELECT users.id, users.parent, users.name\n" +
            "   FROM users\n" +
            "      JOIN r\n" +
            "          ON users.parent = r.id\n" +
            ")\n" +
            "\n" +
            "SELECT * FROM r";
}
