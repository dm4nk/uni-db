package com.dm4nk.unidb.controllers;

import com.dm4nk.unidb.model.response.OpponentsResponse;
import com.dm4nk.unidb.model.response.TicketResponse;
import com.dm4nk.unidb.model.response.UserResponse;
import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dm4nk.unidb.Queries.*;
import static org.jooq.impl.DSL.val;

@RestController
@RequestMapping("api/v1/")
public class QueryController {
    private final DSLContext context;

    public QueryController(DSLContext context) {
        this.context = context;
    }

    @GetMapping("users/longestcomments")
    public List<UserResponse> getUsersWithAverageNetWorthByRole() {
        return context.fetch(USER_WITH_AVERAGE_NET_WORTH).into(UserResponse.class);
    }

    @GetMapping("tickets")
    public List<TicketResponse> getTicketsWithNComments(@RequestParam() int minComments) {
        if (minComments < 1) {
            throw new RuntimeException("Minimal number of comments must be grater then 0");
        }
        return context.resultQuery(TICKETS_WITH_N_COMMENTS, val(minComments)).fetch().into(TicketResponse.class);
    }

    @GetMapping("tickets/comments")
    public List<TicketResponse> getTicketsWithComments() {
        return context.fetch(TICKETS_WITH_COMMENTS).into(TicketResponse.class);
    }

    @GetMapping("tickets/comments/left")
    public List<TicketResponse> getTicketsWithCommentsLeft() {
        return context.fetch(TICKETS_WITH_COMMENTS_LEFT).into(TicketResponse.class);
    }

    @GetMapping("users/comments")
    public List<UserResponse> getUsersWithComments() {
        return context.fetch(USERS_WITH_COMMENTS).into(UserResponse.class);
    }

    @GetMapping("users/opponents")
    public List<OpponentsResponse> getPotentialOpponents() {
        return context.fetch(POTENTIAL_OPPONENTS).into(OpponentsResponse.class);
    }


    @GetMapping("users/children")
    public List<UserResponse> getUsersWithChildren() {
        return context.fetch(USERS_CHILDREN).into(UserResponse.class);
    }
}
