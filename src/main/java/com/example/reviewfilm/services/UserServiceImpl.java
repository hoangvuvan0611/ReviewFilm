package com.example.reviewfilm.services;

import com.example.reviewfilm.model.dtos.UserDTO;
import com.example.reviewfilm.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserDTO createUser(User user) {

        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public UserDTO updateUser(User user) {
        return null;
    }

    @Override
    public List<UserDTO> allUser() {
        return null;
    }

    @Override
    public UserDTO singleUser(String uId) {
        return null;
    }
}
