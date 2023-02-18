package com.system.readnovel.pojo;


import com.system.readnovel.entity.Feedback;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackPojo {

    private Integer id;

    private  String fullname;

    private String email;
    private  String subject;
    private  String message;

    public FeedbackPojo(Feedback feedback) {
        this.id=feedback.getId();
        this.fullname=feedback.getFullname();
        this.email=feedback.getEmail();
        this.subject=feedback.getSubject();
        this.message=feedback.getMessage();
    }
}