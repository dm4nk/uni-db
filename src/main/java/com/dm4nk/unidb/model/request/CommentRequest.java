package com.dm4nk.unidb.model.request;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class CommentRequest {
    private UUID id;
    private UUID ticket;
    private UUID author;
    private String content;
    private OffsetDateTime createdAt;
}
