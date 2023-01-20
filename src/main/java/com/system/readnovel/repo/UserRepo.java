package com.system.readnovel.repo;


import com.system.readnovel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<Object> findByEmail(String email);
    Optional<Object> findByPassword(String password);
}