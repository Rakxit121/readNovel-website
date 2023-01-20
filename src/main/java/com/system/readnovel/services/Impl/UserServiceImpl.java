package com.system.readnovel.services.Impl;

import com.system.readnovel.services.UserService;
import com.system.readnovel.entity.User;
import com.system.readnovel.pojo.UserPojo;
import com.system.readnovel.entity.*;
import com.system.readnovel.repo.*;
import com.system.readnovel.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    public final UserRepo userRepo;

    @Override
    public String save(UserPojo userPojo) {
        User user=new User();
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }


    @Override
    public UserPojo findByEmail(String email) {
        User user = (User) userRepo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Invalid User email"));
        return new UserPojo(user);
    }

    @Override
    public UserPojo findByPassword(String password) {
        User user = (User) userRepo.findByPassword(password)
                .orElseThrow(() -> new RuntimeException("Invalid User password"));
        return new UserPojo(user);
    }

}
