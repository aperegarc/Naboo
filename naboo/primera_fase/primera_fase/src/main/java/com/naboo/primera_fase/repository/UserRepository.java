package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findById(Integer id);
}
