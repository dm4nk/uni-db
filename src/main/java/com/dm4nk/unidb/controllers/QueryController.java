package com.dm4nk.unidb.controllers;

import com.dm4nk.unidb.model.response.OpponentsResponse;
import com.dm4nk.unidb.model.response.TicketResponse;
import com.dm4nk.unidb.model.response.UserResponse;
import org.jooq.DSLContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dm4nk.unidb.Queries.POTENTIAL_OPPONENTS;
import static com.dm4nk.unidb.Queries.TICKETS_WITH_COMMENTS;
import static com.dm4nk.unidb.Queries.TICKETS_WITH_COMMENTS_LEFT;
import static com.dm4nk.unidb.Queries.TICKETS_WITH_N_COMMENTS;
import static com.dm4nk.unidb.Queries.USERS_CHILDREN;
import static com.dm4nk.unidb.Queries.USERS_WITH_COMMENTS;
import static com.dm4nk.unidb.Queries.USER_WITH_AVERAGE_NET_WORTH;
import static org.jooq.impl.DSL.val;

@RestController
@RequestMapping("api/v1/")
public class QueryController {
    private final DSLContext context;

    public QueryController(DSLContext context) {
        this.context = context;
    }

    @GetMapping("users/average")
    public ResponseEntity<List<UserResponse>> getUsersWithAverageNetWorthByRole() {
        return ResponseEntity.ok(context.fetch(USER_WITH_AVERAGE_NET_WORTH).into(UserResponse.class));
    }

    @GetMapping("tickets")
    public ResponseEntity<List<TicketResponse>> getTicketsWithNComments(@RequestParam() int minComments) {
        if (minComments < 1) {
            throw new RuntimeException("Minimal number of comments must be grater then 0");
        }
        return ResponseEntity.ok(context.resultQuery(TICKETS_WITH_N_COMMENTS, val(minComments)).fetch().into(TicketResponse.class));
    }

    @GetMapping("tickets/comments")
    public ResponseEntity<List<TicketResponse>> getTicketsWithComments() {
        return ResponseEntity.ok(context.fetch(TICKETS_WITH_COMMENTS).into(TicketResponse.class));
    }

    @GetMapping("tickets/comments/left")
    public ResponseEntity<List<TicketResponse>> getTicketsWithCommentsLeft() {
        return ResponseEntity.ok(context.fetch(TICKETS_WITH_COMMENTS_LEFT).into(TicketResponse.class));
    }

    @GetMapping("users/comments")
    public ResponseEntity<List<UserResponse>> getUsersWithComments() {
        return ResponseEntity.ok(context.fetch(USERS_WITH_COMMENTS).into(UserResponse.class));
    }

    @GetMapping("users/opponents")
    public ResponseEntity<List<OpponentsResponse>> getPotentialOpponents() {
        return ResponseEntity.ok(context.fetch(POTENTIAL_OPPONENTS).into(OpponentsResponse.class));
    }


    @GetMapping("users/children")
    public ResponseEntity<List<UserResponse>> getUsersWithChildren() {
        return ResponseEntity.ok(context.fetch(USERS_CHILDREN).into(UserResponse.class));
    }
}
