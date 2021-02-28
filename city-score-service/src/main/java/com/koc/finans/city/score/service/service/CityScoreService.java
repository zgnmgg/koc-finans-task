package com.koc.finans.city.score.service.service;

import com.koc.finans.city.score.service.enums.CityCode;
import com.koc.finans.city.score.service.response.CityScoreResponse;
import com.koc.finans.city.score.service.exception.CityScoreException;
import org.springframework.stereotype.Service;

@Service
public class CityScoreService {

    /**
     * Set score with code. Get enum value via code parameter
     *
     * @param code: String
     *
     * @return CityScoreResponse
     *
     */
    public CityScoreResponse setScore(String code) throws Exception {
        try {

            CityScoreResponse cityScoreResponse = new CityScoreResponse();
            cityScoreResponse.setScore(CityCode.valueOf(code).getValue());
            return cityScoreResponse;

        } catch (Exception e) {
            throw new CityScoreException();
        }
    }
}
