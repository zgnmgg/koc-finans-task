package com.koc.finans.api.service.controller;

import com.koc.finans.api.service.exception.UserNotFoundException;
import com.koc.finans.api.service.model.UserModel;
import com.koc.finans.api.service.model.UserScoreDTO;
import com.koc.finans.api.service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handle user add request. Returns user model
     *
     * @param userScoreDTO: UserScoreDTO
     *
     * @return UserModel
     *
     */
    @PostMapping(value = "/add-user")
    @Transactional
    public ResponseEntity<UserModel> addScore(
        @RequestBody UserScoreDTO userScoreDTO
    ) {
        return ResponseEntity.ok().body(this.userService.setUserModel(userScoreDTO));
    }

    /**
     * Handle user score request. Returns user score given parameters
     *
     * @param identityNumber: String
     *
     * @return UserModel
     *
     * @throws UserNotFoundException - if User is not found
     */
    @GetMapping(value = "/score/{identity_number}")
    public ResponseEntity<UserModel> getUserScore(
        @PathVariable("identity_number") String identityNumber
    ) {
        UserModel userModel = this.userService.getUserScoreByIdentityNumber(identityNumber);

        if(userModel != null) {
            return ResponseEntity.ok().body(userModel);
        } else {
            throw new UserNotFoundException();
        }
    }
}


