package fr.fms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.MyUserRepository;
import fr.fms.entities.Category;
import fr.fms.entities.MyUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	private ContactRepository contactRepository;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private MyUserRepository userRepository;

	@InjectMocks
	private SpringContactApp app;

	// Testing if test runner works ^^'
	@Test
	void contextLoads() {
		assertFalse(1 == 2);
	}

	@Test
	@DisplayName("findCategoryByName - Doit retourner la catégorie trouvée")
	public void findCategoryByName_shouldReturnCategory() {
		// Category mocking
		Category mockCategory = new Category("SG1");
		// Test condition
		when(categoryRepository.findByName("SG1")).thenReturn(mockCategory);
		// Method test itself
		Category result = categoryRepository.findByName("SG1");
		// Assertion
		assertThat(result.getName().equals("SG1"));
	}

	@Test
	@DisplayName("userFindByName - Doit retourner le bon user")
	public void userFindByName_shouldReturnContactList() {
		// User list mocking
		Optional<MyUser> mockUser = Optional.of(new MyUser("Carter", "", "", ""));

		// Test condition
		when(userRepository.findByUsername("Carter"))
				.thenReturn(mockUser);

		// Method test
		Optional<MyUser> result = userRepository.findByUsername("Carter");

		// Assertion
		assertThat(result.get().getUsername()).isEqualTo("Carter");
	}

}
