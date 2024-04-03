package com.dm4nk.unidb.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UserRequest {
    public UUID id;
    public UUID parent;
    public String name;
    public String role;
    public BigDecimal netWorth;
}
