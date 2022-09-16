package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	// 함수를 새로 만든것같음
	MemberEntity findById(long i);

	// 이건 왜 long 형으로 별도 변경해서 한걸까?
	void deleteById(long i);

}
