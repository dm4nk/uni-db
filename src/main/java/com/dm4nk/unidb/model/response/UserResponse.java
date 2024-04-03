package com.dm4nk.unidb.model.response;

import lombok.Data;

@Data
public class UserResponse {
    public String id;
    public String parent;
    public String name;
    public String role;
    public Double netWorth;
    public Double averageNetWorth;
    public String comment;
}
