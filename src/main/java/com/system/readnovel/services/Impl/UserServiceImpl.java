package com.system.readnovel.services.Impl;

import com.system.readnovel.config.PasswordEncoderUtil;
import com.system.readnovel.exception.AppException;
import com.system.readnovel.services.UserService;
import com.system.readnovel.entity.User;
import com.system.readnovel.pojo.UserPojo;
import com.system.readnovel.entity.*;
import com.system.readnovel.repo.*;
import com.system.readnovel.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "created";
    }


    @Override
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }

}
