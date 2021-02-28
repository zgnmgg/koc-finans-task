package com.koc.finans.identity.score.service.service;

import com.koc.finans.identity.score.service.response.IdentityScoreResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IdentityScoreServiceTest {

    @InjectMocks
    private IdentityScoreService identityScoreService;

    @Test
    public void setScoreTest() {
        IdentityScoreResponse response = identityScoreService.setScore();

        Assertions.assertNotEquals(response.getScore(), 10);

    }

}