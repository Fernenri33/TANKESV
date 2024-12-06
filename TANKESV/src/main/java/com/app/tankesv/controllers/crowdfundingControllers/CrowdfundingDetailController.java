package com.app.tankesv.controllers.crowdfundingControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.repo.CrowdfundingImgRepo;
import com.app.tankesv.repo.CrowdfundingRepo;
import com.app.tankesv.service.crowdfundingService.CrowdfundingService;

@Controller
public class CrowdfundingDetailController {
    
    @Autowired CrowdfundingRepo crowdfundingRepo;
    @Autowired CrowdfundingImgRepo crowdfundingImgRepo;
    @Autowired CrowdfundingService crowdfundingService;

    @GetMapping("/crowdfundingDetalle/{id}")
    public String mostrarCrowdfundingDetail(@PathVariable Long id, Model model){

        Integer integerId = Math.toIntExact(id);

        Crowdfunding crowdfunding = crowdfundingRepo.findById(integerId).orElseThrow(() -> new IllegalArgumentException("Emprendimiento no encontrado"));
        model.addAttribute("crowdfunding", crowdfunding);

        return "crowdfunding/crowdfundingDetail";
    }

}
