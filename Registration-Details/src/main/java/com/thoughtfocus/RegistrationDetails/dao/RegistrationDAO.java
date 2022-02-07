package com.thoughtfocus.RegistrationDetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtfocus.RegistrationDetails.entity.UserEntity;


public interface RegistrationDAO extends JpaRepository<UserEntity,Integer> {


	UserEntity getByUsername(String username);

}
