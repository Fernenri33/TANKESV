package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Crowdfunding;

public interface CrowdfundingRepo extends JpaRepository<Crowdfunding,Integer>{
    
}
