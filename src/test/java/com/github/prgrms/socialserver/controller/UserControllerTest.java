package com.github.prgrms.socialserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 유저_목록을_요청한다() throws Exception {
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.result[0].seq").value(1L))
            .andExpect(jsonPath("$.result[1].seq").value(2L))
            .andExpect(jsonPath("$.error").doesNotExist());
    }

}