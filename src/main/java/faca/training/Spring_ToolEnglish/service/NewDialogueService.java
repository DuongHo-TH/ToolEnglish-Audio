package faca.training.Spring_ToolEnglish.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faca.training.Spring_ToolEnglish.dao.NewDialogueDao;
import faca.training.Spring_ToolEnglish.entities.NewDialogue;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewDialogueService {

	@Autowired
	private NewDialogueDao dialogue;
	
	  public void createnewword(NewDialogue newword) {
		  dialogue.save(newword);
	  }
	  public List<NewDialogue> findall(){
		 return dialogue.findAll();
	  }
	  public NewDialogue findnewword() {
		  int n = dialogue.findAll().size();
		  Random random = new Random();
		  int id = random.nextInt(n);
		  return dialogue.findById(id).orElse(null);
	  }
	  public NewDialogue findById() {
		  int n = dialogue.findAll().size();
		  Random random = new Random();
		  int id = random.nextInt(n);
		  return dialogue.findById(id).orElse(null);
	  }
	  public NewDialogue findbynewdate() {
		  int n = dialogue.findAll().size();
		  Random random = new Random();
		  int id = random.nextInt(n);
		  LocalDate date = LocalDate.of(2024, 8, 5);
		  return dialogue.findbynewdate(id, date).orElse(null);
	  }
}
