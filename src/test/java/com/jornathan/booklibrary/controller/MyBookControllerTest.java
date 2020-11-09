package com.jornathan.booklibrary.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyBookControllerTest {

  @Autowired
  private WebApplicationContext ctx;

  @Autowired
  private MockMvc mockMvc;

  //@AutoConfigureMockMvc 이 어노테이션이 아래의 내용을 대체,
  //또한 MockMvcBuilder 가 필요 없게 된다.
  //    @BeforeEach
  //    public void setUp(){
  //        this.mockMvc = MockMvcBuilder.webAppContextSetup(this.ctx).build();
  //    }

  @Test
  public void testGetAllBooks() throws Exception {
    MvcResult result = this.mockMvc.perform(get("/books"))
                                   //.andDo(print()) 너무 많이 찍는다.
                                   .andExpect(status().isOk())
                                   //.andExpect(jsonPath("result").value("Aloha"))  이거는 될때가 있고, 안될 때도 있다.
                                   .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println("{testGetAllBooks} response : " + content);
  }


  @Test
  void testGetBook() throws Exception {
    MvcResult result = this.mockMvc.perform(get("/books/tag/A-001"))
                                   //.andDo(print()) 너무 많이 찍는다.
                                   .andExpect(status().isOk())
                                   .andExpect(jsonPath("tag").value("A-001"))  //이거는 될때가 있고, 안될 때도 있다.
                                   .andReturn();

    String content = result.getResponse().getContentAsString();
    System.out.println("{testGetBook} response : " + content);
  }

  @Test
  void searchBooks() {
  }

  @Test
  void updateBook() {
  }
}