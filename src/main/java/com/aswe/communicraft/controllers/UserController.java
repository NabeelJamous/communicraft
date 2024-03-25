package com.aswe.communicraft.controllers;

import com.aswe.communicraft.exceptions.NotFoundException;
import com.aswe.communicraft.models.dto.UserDto;
import com.aswe.communicraft.models.enums.Craft;
import com.aswe.communicraft.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("/{id}")
    public ResponseEntity<String> updateInformation(@PathVariable int id, @RequestBody UserDto userDto) throws NotFoundException {
        userService.update(userDto , id);
        return ResponseEntity.ok("User updated successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable int id) throws NotFoundException {
        UserDto userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable int id) throws NotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");

    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDto>> findAllUsers() throws NotFoundException {
       List<UserDto> users = userService.findAllUsers();
        LOGGER.info("Get all users in the system.");
        return ResponseEntity.ok(users);
    }

    @GetMapping("username/{name}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String name) throws NotFoundException {
        UserDto user = userService.findByUsername(name);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/crafts/{name}")
    public ResponseEntity<List<UserDto>> findUsersByCraft(@PathVariable Craft name) throws NotFoundException {
        List<UserDto> users = userService.findUsersByCraft(name);
        return ResponseEntity.ok(users);
    }

}