package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.MyUserRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;

@Controller
public class ContactController {
	@Autowired
	MyUserRepository userRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
		
	public ContactController() {}
		
	@GetMapping("/index")
	public String index(Model model, @RequestParam(defaultValue="")String username) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<Category> categories = categoryRepository.findAll();
		List<Contact> contacts = contactRepository.findAll();
		model.addAttribute("listContacts", contacts);
		model.addAttribute("listCategory", categories);
		if(currentPrincipalName == "anonymousUser") {
			currentPrincipalName = "stranger";
		}
		model.addAttribute("username", currentPrincipalName);
		return "contacts";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("contact", new Contact());
		model.addAttribute("listCategory", categories);
		return "add";
	}
	
	@PostMapping("save")
	public String save(Model model, Contact contact, Long categoryId, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "contacts";
		}
		Category category = categoryRepository.findById(categoryId).get();
		contact.setCategory(category);
		contactRepository.save(contact);
		return "redirect:/index";
	}
	
	@GetMapping("delete")
	public String delete(Model model, Long id) {
		contactRepository.deleteById(id);
		return "redirect:/index";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		List<Category> categories = categoryRepository.findAll();
		Contact contact = contactRepository.findById(id).get();
		model.addAttribute("contact", contact);
		model.addAttribute("listCategories", categories);
		
		return "edit";
	}
	
	@PostMapping("update")
	public String update(Model model, Contact contact, Long categoryId, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "contacts";
		}
		Category category = categoryRepository.findById(categoryId).get();
		contact.setCategory(category);
		contactRepository.save(contact);
		return "redirect:/index";
	}
	
    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
