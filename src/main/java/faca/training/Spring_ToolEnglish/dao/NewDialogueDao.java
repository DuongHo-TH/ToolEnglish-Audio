package faca.training.Spring_ToolEnglish.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import faca.training.Spring_ToolEnglish.entities.NewDialogue;

public interface NewDialogueDao extends JpaRepository<NewDialogue, Integer>{

	@Query("FROM NewDialogue n Where n.id =?1 and newdate >=?2")
	Optional<NewDialogue> findbynewdate(int id, LocalDate date);
}
