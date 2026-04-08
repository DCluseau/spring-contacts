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
//		MyUser sam = new MyUser("Carter", "Samantha", "major.samantha.carter@sgc.com", "USER");
		// $2a$12$xoThgJFRpHCulcIVoZkReeeUewlMNCoF2CCnANX7ScvSzJbbu0v72
//		MyUser jack = new MyUser("O'Neill", "Jacks", "jack.o'neill@sgc.com", "USER");
//		$2a$12$TDmrH1G8DwMq8kklH0hY1eXKfwX8lrOI.QQGugyKcZFWl3MVb6qNO
//		userRepository.save(jack);
//		Category admin = new Category("Admin");
//		Category sg1 = new Category("SG1");
//		Category medic = new Category("Medic");
//		userRepository.save(sam);
//		categoryRepository.save(admin);
//		categoryRepository.save(sg1);
//		categoryRepository.save(medic);
//		MyUser sam = userRepository.findByUsername("Carter").get();
//		MyUser jack = userRepository.findByUsername("O'Neill").get();
//		Category sg1 = categoryRepository.findByName("SG1");
//		contactRepository.save(new Contact("Carter", "major.samantha.carter@sgc.com", jack, sg1));
//		contactRepository.save(new Contact("O'Neill", "jack.oneill@sgc.us", sam, sg1));
//		contactRepository.save(new Contact("Jackson", "daniel.jackson@sgc.us", sam, sg1));
//		contactRepository.save(new Contact("Frasier", "janet.frasier@sgc.us", sam, medic));
//		contactRepository.save(new Contact("Hammond", "georges.hammond@sgc.us", sam, admin));
	}
}
