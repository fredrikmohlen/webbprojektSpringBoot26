package org.example.webbprojektspringboot26;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void homepageReturnsIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("heroText"))
                .andExpect(model().attributeExists("quoteText"));
    }
}
