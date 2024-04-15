package com.dm4nk.unidb.controllers;

import com.dm4nk.unidb.model.request.CommentRequest;
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

import static com.dm4nk.unidb.generated.jooq.tables.Comments.COMMENTS;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {
    private final DSLContext context;

    public CommentsController(DSLContext context) {
        this.context = context;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest request) {
        context.insertInto(COMMENTS, COMMENTS.TICKET, COMMENTS.AUTHOR, COMMENTS.CONTENT, COMMENTS.CREATED_AT)
                .values(request.getTicket(), request.getAuthor(), request.getContent(), request.getCreatedAt())
                .execute();

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<CommentResponse> updateComment(@RequestBody CommentRequest request) {
        context.update(COMMENTS)
                .set(COMMENTS.TICKET, request.getTicket())
                .set(COMMENTS.AUTHOR, request.getAuthor())
                .set(COMMENTS.CONTENT, request.getContent())
                .set(COMMENTS.CREATED_AT, request.getCreatedAt())
                .where(COMMENTS.ID.eq(request.getId()))
                .execute();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<CommentResponse> deleteComment(@RequestParam UUID uuid) {
        context.delete(COMMENTS)
                .where(COMMENTS.ID.eq(uuid))
                .execute();
        return ResponseEntity.ok().build();
    }
}
