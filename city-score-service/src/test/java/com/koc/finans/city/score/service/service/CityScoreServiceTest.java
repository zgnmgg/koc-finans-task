package com.koc.finans.city.score.service.service;

import com.koc.finans.city.score.service.response.CityScoreResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CityScoreServiceTest {
    @InjectMocks
    private CityScoreService cityScoreService;

    @Test
    public void setScoreTest() throws Exception {
        String code = "i07";
        CityScoreResponse response = cityScoreService.setScore(code);

        Assertions.assertEquals(response.getScore(), 2);

    }
}