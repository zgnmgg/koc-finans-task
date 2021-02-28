package com.koc.finans.city.score.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koc.finans.city.score.service.service.CityScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityScoreController.class)
class CityScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CityScoreService cityScoreService;

    @Test
    void getCityScore() throws Exception {
        String code = "i02";
        String url = "/city-score/" + code;

        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}