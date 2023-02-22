package com.system.readnovel.services;

import com.system.readnovel.entity.Feedback;
import com.system.readnovel.pojo.FeedbackPojo;
import com.system.readnovel.pojo.UserPojo;

import java.util.List;


public interface UserService {

    String save(UserPojo userpojo);
    UserPojo findByEmail(String email);

    String submitFeedback(FeedbackPojo feedbackPojo);
    List<Feedback> fetchAllFeedback();

//    void deleteById(Integer id);
    void deleteFeedback(Integer id);
//    void deletecomment(Integer id);

}
