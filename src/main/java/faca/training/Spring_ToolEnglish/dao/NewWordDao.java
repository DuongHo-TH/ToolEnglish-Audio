package faca.training.Spring_ToolEnglish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import faca.training.Spring_ToolEnglish.entities.NewWord;

public interface NewWordDao extends JpaRepository<NewWord, Integer> {

	@Query ("FROM NewWord ORDER BY NEWID()")
	List<NewWord> finvietnamese();
	
	@Query ("FROM NewWord WHERE dahoc is Null ORDER BY id ASC ")
	List<NewWord> findid();
	
	@Query("FROM NewWord n Where n.id BETWEEN :id AND :id2")
	List<NewWord> findlistdahoc(int id, int id2);
	
	@Query("FROM NewWord n Where n.id = :i and n.dahoc = '1'")
	NewWord findbyiddahoc(int i); 
	
	@Query("FROM NewWord n Where n.id = :i and n.dahoc is null")
	NewWord findbyidchuahoc(int i);
	
	@Query("FROM NewWord n Where n.dahoc = '1' ORDER BY NEWID()")
	List<NewWord> findlistdahoc();
}
