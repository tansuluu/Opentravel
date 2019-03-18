package com.example.opentravel.test;

import com.example.opentravel.controller.LoginController;
import com.example.opentravel.model.User;
import com.example.opentravel.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private LoginController controller;

    @Mock
    private UserService service;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new LoginController())
                .setViewResolvers(viewResolver)
                .build();
    }
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }

    @Test
    public void loginForm_ShouldIncludeNewUserInModel() throws Exception {
        User user = new User();
        user.setEmail("meder");
        user.setPassword("secret");

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
                //.andExpect(model().attribute("user", instanceOf(User.class)));

    }

//    @Test
//    public void registerForm_ShouldIncludeNewUserDtoInModel() throws Exception {
//        mockMvc.perform(get("/register"))
////                .andExpect(status().isOk())
//   //             .andExpect(view().name("register"))
//                .andExpect(model().attribute("user", instanceOf(UserService.class)));
//    }

    @Test
    public void createUser_ShouldCreateUserWithValidCredentials() throws Exception {
        User user = new User();
                user.setName("meder");
                user.setImage("img");
                user.setId(1);
                user.setPassword("secret");
                user.setStatus("status");
                user.setActive(1);
                user.setCountry("KG");
                user.setToken("token");
                user.setAboutMe("me about");
                user.setAge("26");
                user.setEmail("email");
                user.setExperience("emeefdfsdf");
                user.setGender("male");
                user.setLanguages("en");

        mockMvc.perform(
                post("/register")
                        .requestAttr("user", user)
        );
//        verify(service).saveUser(user, "user");
    }
}
