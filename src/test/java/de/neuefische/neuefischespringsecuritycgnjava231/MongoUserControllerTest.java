package de.neuefische.neuefischespringsecuritycgnjava231;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MongoUserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    @WithMockUser(username = "user", password = "123")
    void getMe_whenAuthenticated_thenUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me"))
                .andExpect(status().isOk())
                .andExpect(content().string("user"));
    }
}