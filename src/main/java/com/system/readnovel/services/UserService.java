package com.system.readnovel.services;

import com.system.readnovel.pojo.UserPojo;
import com.system.readnovel.pojo.UserPojo.*;


public interface UserService {

    String save(UserPojo userpojo);
    UserPojo findByEmail(String email);

    UserPojo findByPassword(String password);
}
