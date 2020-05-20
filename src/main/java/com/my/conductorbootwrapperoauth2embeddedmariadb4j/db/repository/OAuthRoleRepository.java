package com.my.conductorbootwrapperoauth2embeddedmariadb4j.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.conductorbootwrapperoauth2embeddedmariadb4j.db.entity.OAuthRole;

public interface OAuthRoleRepository extends JpaRepository<OAuthRole, Integer> {
	
	OAuthRole findByName(String name);

}
