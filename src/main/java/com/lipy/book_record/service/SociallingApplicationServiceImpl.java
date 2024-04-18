package com.lipy.book_record.service;

import com.lipy.book_record.entity.SociallingApplication;
import com.lipy.book_record.repository.SociallingApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// impl은 서비스인터페이스의 구현체
@Service
public class SociallingApplicationServiceImpl implements SociallingApplicationService {

    private final SociallingApplicationRepository applicationRepository;

    @Autowired
    public SociallingApplicationServiceImpl(SociallingApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void applyForSocialling(Long sociallingId, Long applicantId) {
        SociallingApplication application = new SociallingApplication();
        application.setSociallingId(sociallingId);
        application.setApplicantId(applicantId);
        application.setStatus("Pending"); // 처음에는 "대기 중" 상태로 저장
        applicationRepository.save(application);
    }

}

