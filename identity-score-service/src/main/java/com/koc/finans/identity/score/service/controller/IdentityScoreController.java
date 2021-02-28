package com.koc.finans.identity.score.service.controller;

import com.koc.finans.identity.score.service.response.IdentityScoreResponse;
import com.koc.finans.identity.score.service.service.IdentityScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identity-score")
@Slf4j
public class IdentityScoreController {

    private final IdentityScoreService identityScoreService;

    public IdentityScoreController(IdentityScoreService identityScoreService) {
        this.identityScoreService = identityScoreService;
    }

    /**
     * Handle identity score request. Returns score
     *
     * @return IdentityScoreResponse
     *
     */
    @GetMapping(value = "/{identity}")
    public ResponseEntity<IdentityScoreResponse> getIdentityScore(@PathVariable("identity") String identityNumber) {

        return ResponseEntity.ok().body(this.identityScoreService.setScore());
    }
}

