package com.lipy.book_record.repository;

import com.lipy.book_record.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
