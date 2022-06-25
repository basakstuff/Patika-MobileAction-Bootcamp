package com.basaker.homeworki.dao;


import com.basaker.homeworki.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsDao extends JpaRepository<Comments, Long> {

}
