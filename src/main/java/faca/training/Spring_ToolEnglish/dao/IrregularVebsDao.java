package faca.training.Spring_ToolEnglish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import faca.training.Spring_ToolEnglish.entities.IrregularVerbs;



public interface IrregularVebsDao extends JpaRepository<IrregularVerbs, Integer> {

	
	@Query ("FROM IrregularVerbs WHERE dahoc is Null ORDER BY id ASC ")
	List<IrregularVerbs> findid();
	
	@Query("FROM IrregularVerbs n Where n.id BETWEEN :id AND :id2")
	List<IrregularVerbs> findlistdahoc(int id, int id2);
	
	@Query("FROM IrregularVerbs n Where n.id = :i and n.dahoc = '1'")
	IrregularVerbs findbyiddahoc(int i); 
	
	@Query("FROM IrregularVerbs n Where n.id = :i and n.dahoc is null")
	IrregularVerbs findbyidchuahoc(int i);
	
	@Query("FROM IrregularVerbs n Where n.dahoc = '1' ORDER BY NEWID()")
	List<IrregularVerbs> findlistdahoc();
}
