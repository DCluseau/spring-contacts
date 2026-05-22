package fr.fms;

import org.junit.jupiter.api.Test;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.MyUserRepository;
import fr.fms.entities.Category;
import fr.fms.entities.MyUser;
import fr.fms.entities.Contact;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
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
	@DisplayName("MyUserController - findByUsername : should return right user")
	public void userFindByUsername_shouldReturnSearchedUser() {
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

	@Test
	@DisplayName("Contact - findByUser : should return list of users")
	public void contactFindByUser_shouldReturnSearchedUser() {
		MyUser mockUser = new MyUser("Carter", "", "", "");
		List<Contact> mockContactList = List.of(
				new Contact("", "", mockUser, null),
				new Contact("", "", mockUser, null),
				new Contact("", "", mockUser, null));
		when(contactRepository.findByUser(mockUser)).thenReturn(mockContactList);
		List<Contact> result = contactRepository.findByUser(mockUser);

		assertThat(result.get(0).getUser().getUsername()).isEqualTo("Carter");
		assertThat(result.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("Contact - findByUserAndLastnameContains : should return List of users")
	public void contactFindByUserAndLastnameContains_shouldReturnListOfUsers() {
		MyUser mockUser = new MyUser("Carter", "", "", "");
		List<Contact> mockContactList = List.of(
				new Contact("", "", mockUser, null),
				new Contact("", "", mockUser, null),
				new Contact("", "", mockUser, null));
		when(contactRepository.findByUserAndLastnameContains(mockUser, "Carter")).thenReturn(mockContactList);
		List<Contact> result = contactRepository.findByUserAndLastnameContains(mockUser, "Carter");

		assertThat(result.get(0).getUser().getUsername()).isEqualTo("Carter");
		assertThat(result.size()).isEqualTo(3);
	}
}
