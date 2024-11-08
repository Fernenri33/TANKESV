package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Login;


public interface LoginRepository extends  JpaRepository<Login, Long>{

   

}
