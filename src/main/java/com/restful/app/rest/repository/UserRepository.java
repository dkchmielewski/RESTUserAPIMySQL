package com.restful.app.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.app.rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

