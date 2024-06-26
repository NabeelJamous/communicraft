package com.aswe.communicraft.services;

import com.aswe.communicraft.exceptions.NotFoundException;
import com.aswe.communicraft.models.dto.ProjectLeaderDto;
import com.aswe.communicraft.models.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface UserService {
    void update(UserDto userDto , HttpServletRequest id) throws NotFoundException;
    UserDto findById(int id) throws NotFoundException;
    void deleteUser(int id) throws NotFoundException;

    List<UserDto> findAllUsers() throws NotFoundException;
    UserDto findByUsername(String name) throws NotFoundException;

    List<UserDto> findUsersByCraft(String craft) throws NotFoundException;
    void makeLeader(ProjectLeaderDto projectLeaderDto) throws NotFoundException;
}
