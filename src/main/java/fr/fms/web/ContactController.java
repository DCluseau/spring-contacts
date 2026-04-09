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
import fr.fms.entities.MyUser;

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
	public String index(Model model, @RequestParam(name="keyword", defaultValue = "")String kw) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<Contact> contacts;
		if(currentPrincipalName == "anonymousUser") {
			currentPrincipalName = "stranger";
		}else {
			MyUser user = userRepository.findByUsername(currentPrincipalName).get();
			List<Category> categories = categoryRepository.findAll();
			if(kw != "") {
//				contacts = contactRepository.findByUserAndLastnameContainsOrFirstnameContainsOrEmailContainsOrPhoneNumberContainsOrAddressContains(user, kw, kw, kw, kw, kw);
//				contacts = contactRepository.findByWithUserAndLastnameContainsOrFirstnameContains(kw, kw, user);
				contacts = contactRepository.findByUserAndLastnameContains(user, kw);
			}else {
				contacts = contactRepository.findByUser(user);
			}
			model.addAttribute("listContacts", contacts);
			model.addAttribute("listCategory", categories);
		}
		model.addAttribute("username", currentPrincipalName);
		model.addAttribute("keyword", kw);
		return "contacts";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("contact", new Contact());
		model.addAttribute("listCategory", categories);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		model.addAttribute("username", currentPrincipalName);
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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		model.addAttribute("username", currentPrincipalName);
		
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
