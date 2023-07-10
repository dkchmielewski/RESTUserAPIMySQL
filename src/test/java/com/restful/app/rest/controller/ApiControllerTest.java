package com.restful.app.rest.controller;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.restful.app.rest.model.User;
import com.restful.app.rest.repository.UserRepository;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void testGetUsers() throws Exception {
		User user = new User(1L, "a", "b", 40, "c");
		List<User> list = new ArrayList<>();
		list.add(user);
		when(repository.findAll()).thenReturn(list);
		mvc.perform(get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].firstName").value("a"));

	}
	
}
