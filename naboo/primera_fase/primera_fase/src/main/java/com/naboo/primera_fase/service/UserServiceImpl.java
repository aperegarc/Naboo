package com.naboo.primera_fase.service;

import com.naboo.primera_fase.entity.User;
import com.naboo.primera_fase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User nuevoUser) {
        User user = userRepository.findById(id).get();
        if(nuevoUser.getName() != null || nuevoUser.getName() != ""){
            user.setName(nuevoUser.getName());
        }
        if(nuevoUser.getRole() != null || nuevoUser.getRole().equals(null)){
            user.setRole(nuevoUser.getRole());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
