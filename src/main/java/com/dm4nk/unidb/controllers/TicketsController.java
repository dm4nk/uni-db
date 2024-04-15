package com.dm4nk.unidb.controllers;

import com.dm4nk.unidb.model.request.TicketRequest;
import com.dm4nk.unidb.model.response.CommentResponse;
import org.jooq.DSLContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.dm4nk.unidb.generated.jooq.tables.Tickets.TICKETS;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketsController {
    private final DSLContext context;

    public TicketsController(DSLContext context) {
        this.context = context;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> createTicket(@RequestBody TicketRequest request) {
        context.insertInto(TICKETS, TICKETS.REPORTER, TICKETS.ASSIGNEE, TICKETS.DESCRIPTION, TICKETS.TITLE)
                .values(request.getReporter(), request.getAssignee(), request.getDescription(), request.getTitle())
                .execute();

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<CommentResponse> updateTicket(@RequestBody TicketRequest request) {
        context.update(TICKETS)
                .set(TICKETS.REPORTER, request.getReporter())
                .set(TICKETS.ASSIGNEE, request.getAssignee())
                .set(TICKETS.DESCRIPTION, request.getDescription())
                .set(TICKETS.TITLE, request.getTitle())
                .where(TICKETS.ID.eq(request.getId()))
                .execute();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<CommentResponse> deleteTicket(@RequestParam UUID uuid) {
        context.delete(TICKETS)
                .where(TICKETS.ID.eq(uuid))
                .execute();
        return ResponseEntity.ok().build();
    }
}
