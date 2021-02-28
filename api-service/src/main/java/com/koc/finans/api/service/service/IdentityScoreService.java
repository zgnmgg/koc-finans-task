package com.koc.finans.api.service.service;

import com.koc.finans.api.service.exception.IdentityScoreRequestException;
import com.koc.finans.api.service.response.IdentityScoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class IdentityScoreService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Send identity service request to get identity score
     *
     * @return IdentityScoreResponse
     */
    public IdentityScoreResponse sendIdentityScoreRequest(String identityNumber) {

        IdentityScoreResponse responseData = null;
        try {
            responseData = restTemplate.getForObject("http://IDENTITY-SCORE-SERVICE/identity-score/" + identityNumber, IdentityScoreResponse.class);
        } catch (HttpClientErrorException e) {
            throw new IdentityScoreRequestException();
        }
        return responseData;
    }

}
