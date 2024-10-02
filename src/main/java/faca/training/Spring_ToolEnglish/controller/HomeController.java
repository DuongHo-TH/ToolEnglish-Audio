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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import faca.training.Spring_ToolEnglish.entities.NewWord;
import faca.training.Spring_ToolEnglish.service.NewWordService;

@Controller
public class HomeController {
	int n = 0;
	int i = 0;
	private final String audio = "D:\\JAVA Spring Boot\\Tool-English\\src\\main\\resources\\static\\audio";
	@Autowired
	private NewWordService service;

	@PostMapping("/addnewword")
	public String saveNewword(Model model, @ModelAttribute NewWord newword, @RequestParam("file")MultipartFile file,
            RedirectAttributes redirectAttributes) {
		if(file != null) {
			  try {
		            String fileName = file.getOriginalFilename();
		            Path path = Paths.get(audio + File.separator + fileName);
		            Files.write(path, file.getBytes());
		           newword.setAmthanh(fileName);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		service.createnewword(newword);
		return  "redirect:/";
	}
	@RequestMapping("/")
	public String showvietnamese(Model model) {
		List<NewWord> vietnamese =  service.findall();
		vietnamese.sort(Comparator.comparing(NewWord::getId));
		model.addAttribute("vietnamese", vietnamese);
		int total = vietnamese.size();
		model.addAttribute("wordtotal", total);
		return "Home";
	}
	
	@GetMapping("/hoctu")
		public String hoctu(Model model) {
		NewWord word;
		do {
		  word = service.findbynewdate();
		}while(word == null);
		model.addAttribute("word", word);
		return "HocTu";
		}
	
	@PostMapping("/kiemtrahoc")
	public String kiemtrahoc(Model model, @ModelAttribute NewWord word, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(word.getEnglish())) {
			NewWord newword;
			do {
			  newword = service.findbynewdate();
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "HocTu";
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "HocTu";
		}
	}
	@GetMapping("/createnewword")
	public String createNewWord() {
		return "/CreateNewWord";
	}
	
	@RequestMapping("/testtu")
	public String testtu(Model model) {
		NewWord word;
		do {
		  word = service.findnewword();
		}while(word == null);
		model.addAttribute("word", word);
		return "TraTu";
	}
	@PostMapping("/kiemtra")
	public String kiemtra(Model model, @ModelAttribute NewWord word, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(word.getEnglish())) {
			NewWord newword;
			do {
			  newword = service.findnewword();
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "TraTu";
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "TraTu";
		}
	}	
	@RequestMapping("/testluyentu")
	public String testluyentu(Model model) {
		List<NewWord> listword = service.findi();
		NewWord word1 = Collections.min(listword,Comparator.comparingInt(NewWord::getId));
		i = word1.getId();
		NewWord word;
		do {
		  word = service.findword(i);
		}while(word == null);
		model.addAttribute("word", word);
		return "LuyenTu";
	}
	@PostMapping("/checkluyentu")
	public String luyenTu(Model model, @ModelAttribute NewWord word, @RequestParam("extraInput") String input) {
		
		if(input.equalsIgnoreCase(word.getEnglish())) {
			NewWord newword;
			n = n + 1;
			if(n > 19) {
				word.setDahoc("1");
				service.createnewword(word);
				i= i + 1;
				n = 0;
			do {
			  newword = service.findword(i);
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "LuyenTu";
			}else {
				model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
				model.addAttribute("word", word);
				return "LuyenTu";
			}
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "LuyenTu";
		}
	}
	@GetMapping("/hocenglish")
	public String english(Model model) {
		NewWord word;
		do {
		  word = service.findnewword();
		}while(word == null);
		model.addAttribute("word", word);
		return "tienganh";
	}
	@PostMapping("/English")
	public String kiemtraEnglish(Model model, @ModelAttribute NewWord word, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(word.getVietnamese())) {
			NewWord newword;
			do {
			  newword = service.findnewword();
			}while(newword == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", newword);
			return "tienganh";
		}else {
			model.addAttribute("word", word);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "tienganh";
		}
	}
	
	@GetMapping("/allword")
	public String allword(Model model) {
		model.addAttribute("item", service.findvietnamese());
		return "KiemTra";
	}
	

    @GetMapping("/editword")
    public String editword(Model model,@RequestParam("id") int id) {
    	
    	model.addAttribute("word", service.findById(id));
    	return "UpdateWord";
    }
}
