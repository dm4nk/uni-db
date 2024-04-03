package com.dm4nk.unidb.model.request;

import lombok.Data;

import java.util.UUID;

@Data
public class TicketRequest {
    private UUID id;
    private UUID reporter;
    private UUID assignee;
    private String description;
    private String title;
}
