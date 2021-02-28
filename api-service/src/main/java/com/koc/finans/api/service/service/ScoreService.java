package com.koc.finans.api.service.service;

import com.koc.finans.api.service.response.CityScoreResponse;
import com.koc.finans.api.service.response.IdentityScoreResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoreService {

    private final CityScoreService cityScoreService;
    private final IdentityScoreService identityScoreService;

    public ScoreService(CityScoreService cityScoreService, IdentityScoreService identityScoreService) {
        this.cityScoreService = cityScoreService;
        this.identityScoreService = identityScoreService;
    }

    /**
     * Set user score with city code, identity and income Multipler
     *
     * @param cityCode: String
     * @param incomeMultipler: int
     *
     * @return score: int
     */
    public int setScore(String identityNumber, String cityCode, int incomeMultipler) {
        CityScoreResponse cityScore = cityScoreService.sendCityScoreRequest(cityCode);
        IdentityScoreResponse identityScore = identityScoreService.sendIdentityScoreRequest(identityNumber);

        return (identityScore.getScore() * incomeMultipler) + cityScore.getScore();
    }
}
