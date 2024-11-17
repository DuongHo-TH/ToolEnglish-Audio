package faca.training.Spring_ToolEnglish.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faca.training.Spring_ToolEnglish.dao.IrregularVebsDao;
import faca.training.Spring_ToolEnglish.entities.IrregularVerbs;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class IrregularVerbsService {
 @Autowired 
 private IrregularVebsDao irredao;
 
 public List<IrregularVerbs> findlistIrre(){
	 return irredao.findAll();
 }
 public void saveIrregularVerbs(IrregularVerbs irre) {
	 irredao.save(irre);
 }
 public List<IrregularVerbs> findi(){
	  return irredao.findid();
 }
 public IrregularVerbs findword(int n) {
	  int size = irredao.findAll().size();
	  int id;
	  if(size > n+10) {
	    Random random = new Random();
	     id = random.nextInt(10) + n;
	    return irredao.findbyidchuahoc(id);
	  }else {
		int m =  n + (size - n);
		int i = m -n;
		  Random random = new Random();
		     id = random.nextInt(i) + n;
		return irredao.findbyidchuahoc(id);
	  }
 }
 public List<IrregularVerbs> finddahoc(int n){
	  int m = n+9;
		 return irredao.findlistdahoc(n,m);
	  }
 public IrregularVerbs findbyiddahoc() {
	 int n = irredao.findlistdahoc().size();
	  Random random = new Random();
	  int id = random.nextInt(n);
	  return irredao.findbyiddahoc(id);
 }
}
