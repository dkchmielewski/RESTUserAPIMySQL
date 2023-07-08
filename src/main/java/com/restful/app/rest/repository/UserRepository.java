package com.restful.app.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.app.rest.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

