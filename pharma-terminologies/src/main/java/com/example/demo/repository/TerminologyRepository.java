package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Terminology;

@Repository
@Transactional
public interface TerminologyRepository extends JpaRepository<Terminology, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Terminology t SET t.shortForm = ?1, t.fullForm = ?2, t.description = ?3 WHERE t.id = ?4")
	int updateTerminology(String shortForm, String fullForm, String description, Integer id);
}
