package com.basaker.homeworki.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {
    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "SURNAME", length = 50)
    private String surname;

    @Column(name = "MAIL", length = 50)
    private String mail;

    @Column(name = "PHONENUMBER", length = 15)
    private String phoneNumber;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

}
