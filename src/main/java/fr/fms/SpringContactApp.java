package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.MyUserRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import fr.fms.entities.MyUser;

@SpringBootApplication
public class SpringContactApp implements CommandLineRunner {

	@Autowired
	private MyUserRepository userRepository;
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringContactApp.class, args);
	}
	
	public void run(String...args) throws Exception{
//		User user = new User("Toto", "pwdfre", "fnjsofrd@fnfvso.jfi");
//		Category category = new Category("Work");
//		userRepository.save(user);
//		categoryRepository.save(category);
//		contactRepository.save(new Contact("Tata", "b.b@b.b", user, category));
	}
}
