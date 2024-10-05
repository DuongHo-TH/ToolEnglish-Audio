package faca.training.Spring_ToolEnglish.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faca.training.Spring_ToolEnglish.dao.NewWordDao;
import faca.training.Spring_ToolEnglish.entities.NewWord;

@Service
public class NewWordService  {
 @Autowired
 private NewWordDao newdao;
  public void createnewword(NewWord newword) {
	  newdao.save(newword);
  }
  public List<NewWord> findi(){
	  return newdao.findid();
  }
  public List<NewWord> findvietnamese() {
	  return  newdao.finvietnamese();
  }
  public List<NewWord> findall(){
	 return newdao.findAll();
  }
  public List<NewWord> finddahoc(int n){
	  int m = n+9;
		 return newdao.findlistdahoc(n,m);
	  }
  public NewWord findnewword() {
	  int n = newdao.findlistdahoc().size();
	  Random random = new Random();
	  int id = random.nextInt(n);
	  return newdao.findbyiddahoc(id);
  }
  public NewWord findword(int n) {
	  int size = newdao.findAll().size();
	  int id;
	  if(size > n+10) {
	    Random random = new Random();
	     id = random.nextInt(10) + n;
	    return newdao.findbyidchuahoc(id);
	  }else {
		 n =  n + (size - n);
		  Random random = new Random();
		     id = random.nextInt(10) + n;
		return newdao.findbyidchuahoc(id);
	  }
	  
  }
  public NewWord findById(int id) {
	  return newdao.findById(id).orElse(null);
  }
  public NewWord findbynewdate() {
	  int n = newdao.findAll().size();
	  Random random = new Random();
	  int id = random.nextInt(n);
	  LocalDate date = LocalDate.of(2024, 8, 14);
	  return newdao.findbynewdate(id, date).orElse(null);
  }
  public void Update(NewWord newword) {
	 NewWord word = findById(newword.getId());
	  word.setEnglish(newword.getEnglish());
	  word.setEnglish(newword.getVietnamese());
	  word.setEnglish(newword.getPhienam());
	  newdao.save(newword);
  }
  }
