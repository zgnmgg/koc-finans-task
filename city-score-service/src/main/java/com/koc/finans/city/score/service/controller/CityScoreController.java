package com.koc.finans.city.score.service.controller;

import com.koc.finans.city.score.service.response.CityScoreResponse;
import com.koc.finans.city.score.service.service.CityScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city-score")
public class CityScoreController {

    private final CityScoreService cityScoreService;

    public CityScoreController(CityScoreService cityScoreService) {
        this.cityScoreService = cityScoreService;
    }

    /**
     * Handle city score request. Returns score
     *
     * @param code: String
     *
     * @return CityScoreResponse
     *
     */
    @GetMapping("/{code}")
    public ResponseEntity<CityScoreResponse> getCityScore(@PathVariable("code") String code) throws Exception {
        return ResponseEntity.ok().body(this.cityScoreService.setScore(code));
    }

}

