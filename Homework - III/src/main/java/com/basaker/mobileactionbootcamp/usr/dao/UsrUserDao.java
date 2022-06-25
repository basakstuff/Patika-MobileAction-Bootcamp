package com.basaker.mobileactionbootcamp.usr.dao;

import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Basak Er
 * @since 1.0.0
 */
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {

    UsrUser findByUsername(String username);

    boolean existsByUsername(String username);
}
