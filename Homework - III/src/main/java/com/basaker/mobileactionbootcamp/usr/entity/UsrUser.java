package com.basaker.mobileactionbootcamp.usr.entity;

import com.basaker.mobileactionbootcamp.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Entity
@Table(name = "USR_USER")
@Getter
@Setter
public class UsrUser extends BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
