package faca.training.Spring_ToolEnglish.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import faca.training.Spring_ToolEnglish.entities.IrregularVerbs;
import faca.training.Spring_ToolEnglish.service.IrregularVerbsService;

@Controller
public class IrregularVerbsController {
	int n = 0;
	int i = 0;
 @Autowired
 private IrregularVerbsService irregu;
 
 private final String audio = "D:\\Spring-Boot\\ToolEnglish-Audio\\src\\main\\resources\\static\\audio";
 
 @RequestMapping("/Irregular")
 public String Irregular(Model model) {
	 model.addAttribute("item", irregu.findlistIrre());
	 return "/IrregularVerbs";
 }
 
 @PostMapping("/saveirregular")
 public String saveIrregular(@ModelAttribute IrregularVerbs irregularverb,
		 @RequestParam("file")MultipartFile file,
		 @RequestParam("filep1")MultipartFile file1,
		 @RequestParam("filep2")MultipartFile file2,
         RedirectAttributes redirectAttributes) {
		if(file != null) {
			  try {
		            String fileName = file.getOriginalFilename();
		            Path path = Paths.get(audio + File.separator + fileName);
		            Files.write(path, file.getBytes());
		           irregularverb.setAmthanh(fileName);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		} 
		if(file1 != null) {
			  try {
		            String fileName1 = file1.getOriginalFilename();
		            Path path = Paths.get(audio + File.separator + fileName1);
		            Files.write(path, file1.getBytes());
		           irregularverb.setAmthanhp1(fileName1);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		} 
		if(file2 != null) {
			  try {
		            String fileName2 = file2.getOriginalFilename();
		            Path path = Paths.get(audio + File.separator + fileName2);
		            Files.write(path, file2.getBytes());
		           irregularverb.setAmthanhp2(fileName2);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		} 
		irregu.saveIrregularVerbs(irregularverb);
	
		return "redirect:/Irregular";
}
 @RequestMapping("/testIrregular")
	public String testluyentu(Model model) {
		List<IrregularVerbs> listword = irregu.findi();
		IrregularVerbs word1 = Collections.min(listword,Comparator.comparingInt(IrregularVerbs::getId));
		i = word1.getId();
		IrregularVerbs word;
		do {
		  word = irregu.findword(i);
		}while(word == null);
		model.addAttribute("word", word);
		return "HocIrregularVerbs";
	}
	@PostMapping("/checkIrregular")
	public String luyenTu(Model model, @ModelAttribute IrregularVerbs word
			, @RequestParam("extraInput") String input
			, @RequestParam("extraInput2") String input2) {
		
		if(input.equalsIgnoreCase(word.getP1())& input2.equalsIgnoreCase(word.getP2()) ) {
			IrregularVerbs newword = irregu.findword(i);
			n = n + 1;
			if(n > 99) {
				List<IrregularVerbs> dahoc = irregu.finddahoc(i);
				for (IrregularVerbs newWord2 : dahoc) {
					newWord2.setDahoc("1");
					irregu.saveIrregularVerbs(newWord2);
				}
				i= i + 10;
				n = 0;
			do {
			  newword = irregu.findword(i);
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "HocIrregularVerbs";
			}else {
				do {
					  newword = irregu.findword(i);
					}while(newword == null);
				model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
				model.addAttribute("word", newword);
				return "HocIrregularVerbs";
			}
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "HocIrregularVerbs";
		}
	}
	
	@RequestMapping("/testIrregulardahoc")
	public String testluyentudahoc(Model model) {
		IrregularVerbs word = new IrregularVerbs();
		do {
		  word = irregu.findbyiddahoc();
		}while(word == null);
		model.addAttribute("word", word);
		return "IrregularVerbsDahoc";
	}
	@PostMapping("/checkIrregulardahoc")
	public String luyenTudahoc(Model model, @ModelAttribute IrregularVerbs word
			, @RequestParam("extraInput") String input
			, @RequestParam("extraInput2") String input2) {
		
		if(input.equalsIgnoreCase(word.getP1())& input2.equalsIgnoreCase(word.getP2()) ) {
			IrregularVerbs newword = irregu.findword(i);
			n = n + 1;
			if(n > 99) {
				List<IrregularVerbs> dahoc = irregu.finddahoc(i);
				for (IrregularVerbs newWord2 : dahoc) {
					newWord2.setDahoc("1");
					irregu.saveIrregularVerbs(newWord2);
				}
				i= i + 10;
				n = 0;
			do {
			  newword = irregu.findbyiddahoc();
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "IrregularVerbsDahoc";
			}else {
				do {
					  newword = irregu.findbyiddahoc();
					}while(newword == null);
				model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
				model.addAttribute("word", newword);
				return "IrregularVerbsDahoc";
			}
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "IrregularVerbsDahoc";
		}
	}
}
