package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.User;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;

@Controller
public class ContactController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public ContactController() {}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Category> categories = categoryRepository.findAll();
		List<Contact> contacts = contactRepository.findAll();
		model.addAttribute("listContacts", contacts);
		model.addAttribute("listCategory", categories);
		
		return "contacts";
	}

}
