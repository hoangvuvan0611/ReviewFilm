package com.example.reviewfilm.services;

import com.example.reviewfilm.model.dtos.UserDTO;
import com.example.reviewfilm.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDTO createUser(User user);
    public void deleteUser(User user);
    public UserDTO updateUser(User user);
    public List<UserDTO> allUser();
    public UserDTO singleUser(String uId);
}
