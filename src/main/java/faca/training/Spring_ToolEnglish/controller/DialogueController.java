package faca.training.Spring_ToolEnglish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import faca.training.Spring_ToolEnglish.entities.NewDialogue;
import faca.training.Spring_ToolEnglish.service.NewDialogueService;

@Controller
public class DialogueController {

	@Autowired
	private NewDialogueService dialogue;
	
	
	@PostMapping("/addnewdialogue")
	public String saveNewword(Model model, @ModelAttribute NewDialogue dia) {
		dialogue.createnewword(dia);
		return  "redirect:/alldialogue";
	}
	
	@GetMapping("/testnewdialogue")
		public String hoctu(Model model) {
		NewDialogue dia;
		do {
		  dia = dialogue.findbynewdate();
		}while(dia == null);
		model.addAttribute("word", dia);
		return "newdialogue";
		}
	
	@PostMapping("/kiemtranewdialogue")
	public String kiemtrahoc(Model model, @ModelAttribute NewDialogue dialo, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(dialo.getEnglish())) {
			NewDialogue dia;
			do {
				dia = dialogue.findbynewdate();
			}while(dia == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", dia);
			return "newdialogue";
		}else {
			model.addAttribute("word", dialo);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "newdialogue";
		}
	}
	@GetMapping("/createnewdialogue")
	public String createNewWord() {
		return "/CreateDialogue";
	}
	
	@RequestMapping("/testalldialogue")
	public String testtu(Model model) {
		NewDialogue dia;
		do {
			dia = dialogue.findById();
		}while(dia == null);
		model.addAttribute("word", dia);
		return "alldialogue";
	}
	@PostMapping("/kiemtradialogue")
	public String kiemtra(Model model, @ModelAttribute NewDialogue dialo, @RequestParam("extraInput") String input) {
		if(input.equalsIgnoreCase(dialo.getEnglish())) {
			NewDialogue dia;
			do {
				dia = dialogue.findById();
			}while(dia == null);
			model.addAttribute("kqtrue", "Trả lời Chính Xác, Tiếp Tục Ôn Luyện Nào");
			model.addAttribute("word", dia);
			return "alldialogue";
		}else {
			model.addAttribute("word", dialo);
			model.addAttribute("kqfalse", "Kiểm Tra Đáp Án Sai Kiểm Tra Lại");
			return "alldialogue";
		}
	}
	
	@GetMapping("/alldialogue")
	public String allword(Model model) {
		model.addAttribute("items", dialogue.findall());
		return "listDialogue";
	}
}
