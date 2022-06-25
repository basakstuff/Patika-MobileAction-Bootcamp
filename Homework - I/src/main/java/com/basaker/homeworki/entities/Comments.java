package com.basaker.homeworki.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
public class Comments {
    @Id
    @SequenceGenerator(name = "Comments", sequenceName = "COMMENTS_ID_SEQ")
    @GeneratedValue(generator = "Comments")
    private Long id;

    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Column(name = "COMMENT_DATE")
    private Date commentDate;

    @Column(name = "PRODUCTID")
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


}
