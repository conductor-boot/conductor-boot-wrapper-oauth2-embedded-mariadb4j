package com.my.conductorbootwrapperoauth2embeddedmariadb4j.auth.server.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.conductorbootwrapperoauth2embeddedmariadb4j.auth.server.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}


