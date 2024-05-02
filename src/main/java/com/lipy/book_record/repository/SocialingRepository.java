package com.lipy.book_record.repository;

import com.lipy.book_record.entity.Socialing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialingRepository extends JpaRepository<Socialing, Long> {
}
