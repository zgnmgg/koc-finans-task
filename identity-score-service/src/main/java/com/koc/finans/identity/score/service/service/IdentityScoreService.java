package com.koc.finans.identity.score.service.service;

import com.koc.finans.identity.score.service.response.IdentityScoreResponse;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdentityScoreService {

    /**
     * Set identity score with random value
     *
     * @return IdentityScoreResponse
     *
     */
    public IdentityScoreResponse setScore() {

        Random rnd = new Random();

        IdentityScoreResponse identityScoreResponse = new IdentityScoreResponse();
        identityScoreResponse.setScore(rnd.nextInt(8) + 1);
        return identityScoreResponse;
    }
}
