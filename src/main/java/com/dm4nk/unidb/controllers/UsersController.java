package com.dm4nk.unidb.controllers;

import com.dm4nk.unidb.model.request.UserRequest;
import com.dm4nk.unidb.model.response.UserResponse;
import org.jooq.DSLContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.dm4nk.unidb.generated.jooq.tables.Users.USERS;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    private final DSLContext context;

    public UsersController(DSLContext context) {
        this.context = context;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        context.insertInto(USERS, USERS.PARENT, USERS.NAME, USERS.ROLE, USERS.NET_WORTH)
                .values(request.getParent(), request.getName(), request.getRole(), request.getNetWorth())
                .execute();

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request) {
        context.update(USERS)
                .set(USERS.PARENT, request.getParent())
                .set(USERS.NAME, request.getName())
                .set(USERS.ROLE, request.getRole())
                .set(USERS.NET_WORTH, request.getNetWorth())
                .where(USERS.ID.eq(request.getId()))
                .execute();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<UserResponse> deleteUser(@RequestParam UUID uuid) {
        context.delete(USERS)
                .where(USERS.ID.eq(uuid))
                .execute();
        return ResponseEntity.ok().build();
    }
}
