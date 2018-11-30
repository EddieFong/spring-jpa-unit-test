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

    @Autowired
    private SingleEntityRepository reposity;

    @Test
    public void should_get_msg() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/message"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("message",is("Message")));
    }


    @Test
    public void should_get_content() throws Exception {
        String json = getJsonResponse("/message");
        ObjectMapper objectMapper = new ObjectMapper();
        MessageResponse actual = objectMapper.readValue(json, MessageResponse.class);
        assertEquals("message", actual.getMessage());
    }

    private String getJsonResponse(String link) throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(link)).andReturn();
        return mvcResult.getResponse().getContentAsString();
    }


    @Test
    public void should_get_content_from_db() throws Exception {

        final String singleEntityName = "Hi";
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.id =  2L;
        singleEntity.name= singleEntityName;
        reposity.save(singleEntity);
        reposity.flush();

        final String json = getJsonResponse("/message");

        ObjectMapper objectMapper = new ObjectMapper();
        MessageResponse actual = objectMapper.readValue(json, MessageResponse.class);
        assertEquals("Hi", actual.getMessage());
    }
}
