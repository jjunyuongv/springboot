package com.edu.springboot.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
DAO 역할의 인터페이스. 
타입매개변수는 테이블로 사용할 Member와 기본키로 설정할 필드의 타입을 명시한다. 
long은 기본자료형이므로 랩퍼클래스인 Long으로 기술해야한다. 
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>
{	
	@Query("SELECT m FROM JPAMEMBER03 m WHERE m.name LIKE "
			+ " :name1 ORDER BY m.id DESC")
	List<Member> findMembers(@Param("name1") String name2);
	
	//정렬을 위한 Sort 사용.
	@Query("SELECT m FROM JPAMEMBER03 m WHERE m.name LIKE :name1")
	List<Member> findMembers(@Param("name1") String name2, Sort sort);
	
	//페이징을 위한 Pageable
	@Query("SELECT m FROM JPAMEMBER03 m WHERE m.name LIKE :name1")
	Page<Member> findMembers(@Param("name1") String name2,
			Pageable pageable);
	
	//일반적인 SQL문 사용. 테이블 등 대소문자를 구분하지 않는다.
	@Query(value = "SELECT * FROM jpamember03 WHERE name LIKE :name1"
			+ " ORDER BY id DESC",
			nativeQuery = true)
	List<Member> findMembersNative(@Param("name1") String name2);

}
