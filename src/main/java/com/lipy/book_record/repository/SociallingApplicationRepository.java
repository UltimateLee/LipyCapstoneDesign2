package com.lipy.book_record.repository;

import com.lipy.book_record.entity.SociallingApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SociallingApplicationRepository extends JpaRepository<SociallingApplication, Long> {

    List<SociallingApplication> findBySociallingId(Long sociallingId);

    List<SociallingApplication> findByApplicantId(Long applicantId);

}