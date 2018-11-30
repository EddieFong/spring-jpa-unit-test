package com.oocl.web.sampleWebApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void should_get_msg() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/message"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("message",is("Message")));
    }

    @Test
    public void should_get_msg2() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/message")).andReturn();
//        assertEquals(mvcResult.getResponse().getStatus(),200);\
        String json = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        MessageResponse actual = objectMapper.readValue(json, MessageResponse.class);
        assertEquals("message", actual.getMessage());
    }

    @Test
    public void should_get_content() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/message")).andReturn();
//        assertEquals(mvcResult.getResponse().getStatus(),200);\
        String json = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        MessageResponse actual = objectMapper.readValue(json, MessageResponse.class);
        assertEquals("message", actual.getMessage());
    }
}
