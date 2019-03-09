package tacos;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHomePage() throws Exception{
		mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/"))
		.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
		.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.view().name("home"))
		.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.content().string(containsString("Welcome to...")));
		
	}

}
