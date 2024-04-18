package com.lipy.book_record.controller;

import com.lipy.book_record.service.SociallingApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SociallingApplicationController {

    private final SociallingApplicationService applicationService;

    @Autowired
    public SociallingApplicationController(SociallingApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/apply")
    public String applyForSocialling(@RequestParam Long sociallingId, @RequestParam Long applicantId) {
        applicationService.applyForSocialling(sociallingId, applicantId);
        return "redirect:/socialling/" + sociallingId; // 신청 후 해당 소셜링 페이지로 리다이렉트
    }
}
