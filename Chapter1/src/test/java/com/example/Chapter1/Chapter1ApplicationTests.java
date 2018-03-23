package com.example.Chapter1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Chapter1.web.UserController;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;    
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import static org.hamcrest.Matchers.equalTo;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MockServletContext.class)
//@SpringBootTest(classes = Application.class) 
@WebAppConfiguration
public class Chapter1ApplicationTests {

	
	private MockMvc mvc;
	private MockMvc userMvc;
	@Before 
	public void setUp() throws Exception
	{
		mvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
		userMvc=MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void getHello() throws Exception{
		ResultActions ra=mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON));
		ra=ra.andExpect(status().isOk());
		ra.andExpect(content().string(equalTo("hello world")));
	}

	@Test 
	public void userTest() throws Exception{
		RequestBuilder request=null;
		
		request=MockMvcRequestBuilders.get("http://localhost:8080/users/");
		mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
							.andExpect(content().string(equalTo("[]")));
		
		
		request=MockMvcRequestBuilders.post("/users/")
									.param("id","1")
									.param("name","zzzzzz")
									.param("age","3");
		
		mvc.perform(request).andExpect(status().isOk());
		
		// 3、get获取user列表，应该有刚才插入的数据 
		request = MockMvcRequestBuilders.get("/users/"); 
		mvc.perform(request) 
						.andExpect(status().isOk()) 
						.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"zzzz\",\"age\":3}]")));
				
		request=MockMvcRequestBuilders.put("users/1").param("name","qk").param("age","18");
			
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		
		// 5、get一个id为1的user 
				request = MockMvcRequestBuilders.get("/users/1"); 
				mvc.perform(request) 
						.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}"))); 
		 
				
				// 6、del删除id为1的user 
				request = MockMvcRequestBuilders. delete("/users/1"); 
				mvc.perform(request) 
						.andExpect(content().string(equalTo("success"))); 
		 
				// 7、get查一下user列表，应该为空 
				request = MockMvcRequestBuilders.get("/users/"); 
				mvc.perform(request) 
						.andExpect(status().isOk()) 
						.andExpect(content().string(equalTo("[]"))); 
			
	}
	
	@Test
	public void contextLoads() {
	}
	
//	@RunWith(SpringJUnit4ClassRunner.class)
//	@SpringBootTest(classes=MockServletContext.class)
//	@WebAppConfiguration
	
}
