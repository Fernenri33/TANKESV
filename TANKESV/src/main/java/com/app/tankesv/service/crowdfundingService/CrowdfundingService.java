package com.app.tankesv.service.crowdfundingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.repo.CrowdfundingRepo;

@Service
public class CrowdfundingService {

    @Autowired
    private CrowdfundingRepo crowdfundingRepo;

    public List<Crowdfunding>obteneCrowdfunding()
    {
        return crowdfundingRepo.findAll();
    }
    
}
