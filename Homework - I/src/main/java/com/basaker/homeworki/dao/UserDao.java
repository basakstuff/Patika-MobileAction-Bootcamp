package com.basaker.homeworki.dao;

import com.basaker.homeworki.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
