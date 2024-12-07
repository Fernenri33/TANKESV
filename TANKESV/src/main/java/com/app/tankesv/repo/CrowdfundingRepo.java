package com.app.tankesv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Crowdfunding;

public interface CrowdfundingRepo extends JpaRepository<Crowdfunding,Integer>{
    
    List<Crowdfunding> findByEmpresario_IdEmpresario(int id);
}
