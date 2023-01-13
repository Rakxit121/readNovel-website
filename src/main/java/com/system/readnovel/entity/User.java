package com.system.readnovel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")

public class User {


    @Id
    @SequenceGenerator(name = "cms_user_seq_gen", sequenceName = "cms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

}
