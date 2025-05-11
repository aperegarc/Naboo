package com.naboo.primera_fase.service;

import com.naboo.primera_fase.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();
    public User getUserById(int userId);
    public User saveUser(User user);
    public User updateUser(Integer id, User nuevouser);
    public void deleteUser(Integer id);

}
