package fr.fms.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.thymeleaf.spring5.expression.Mvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.dao.MyUserRepository;

@WebMvcTest(value = ContactController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
public class ContactControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private Model model;

    @MockBean
    private ContactRepository contactRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private MyUserRepository userRepository;

    @Test
    // @WithMockUser
    // Test endpoint ?
    public void index_Test() throws Exception {
        // Mock authentication ?
        Authentication authentication = mock(Authentication.class);

        // SecurityContextHolder securityContextHolder =
        // mock(SecurityContextHolder.class);
        // Mock currentUser = anonymous
        when(authentication.getName()).thenReturn("anonymousUser");
        mvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
