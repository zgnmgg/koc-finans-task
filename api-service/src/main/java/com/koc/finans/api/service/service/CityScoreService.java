package com.koc.finans.api.service.service;

import com.koc.finans.api.service.exception.CityScoreRequestException;
import com.koc.finans.api.service.response.CityScoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CityScoreService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Send city score service request to get city score
     *
     * @return CityScoreResponse
     */
    public CityScoreResponse sendCityScoreRequest(String cityCode) {

        CityScoreResponse responseData = null;
        try {
            responseData =  restTemplate.getForObject("http://CITY-SCORE-SERVICE/city-score/" + cityCode, CityScoreResponse.class);

        } catch (HttpClientErrorException e) {
            throw new CityScoreRequestException();
        }
        return responseData;
    }
}
