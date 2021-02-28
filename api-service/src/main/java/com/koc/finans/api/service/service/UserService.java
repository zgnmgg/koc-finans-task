package com.koc.finans.api.service.service;

import com.koc.finans.api.service.exception.UserExistsException;
import com.koc.finans.api.service.model.UserModel;
import com.koc.finans.api.service.model.UserScoreDTO;
import com.koc.finans.api.service.model.repo.UserRepository;
import com.koc.finans.api.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ScoreService scoreService;
    private final SmsService smsService;
    private final IncomeService incomeService;

    public UserService(UserRepository userRepository, ScoreService scoreService, SmsService smsService, IncomeService incomeService) {
        this.userRepository = userRepository;
        this.scoreService = scoreService;
        this.smsService = smsService;
        this.incomeService = incomeService;
    }

    /**
     * Handle user add request. Returns user model
     *
     * @param userScoreDTO: UserScoreDTO
     *
     * @return user
     *
     * @throws UserExistsException - if User exists
     */
    public UserModel setUserModel(UserScoreDTO userScoreDTO) {
        if(! this.existsUserByIdentityNumber(userScoreDTO.getIdentityNumber())) {

            UserModel user = new UserModel();
            user.setName(userScoreDTO.getName());
            user.setIdentityNumber(userScoreDTO.getIdentityNumber());
            user.setPhone(userScoreDTO.getPhone());
            user.setCity(userScoreDTO.getCity());
            user.setSurname(userScoreDTO.getSurname());
            user.setScore(
                scoreService.setScore(
                    userScoreDTO.getIdentityNumber(),
                    userScoreDTO.getCity(),
                    this.incomeService.getIncomeByCode(userScoreDTO.getIncome()).getMultipler()
                )
            );

            smsService.sendSms(userScoreDTO.getPhone(), user.getScore());

            userRepository.save(user);

            return user;
        } else {
            throw new UserExistsException();
        }
    }

    /**
     * Get user by identity number
     *
     * @param identityNumber: String
     *
     * @return user
     *
     * @throws UserNotFoundException - if User not found
     */
    public UserModel getUserScoreByIdentityNumber(String identityNumber) {
        return this.userRepository.findUserModelByIdentityNumber(identityNumber).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Exist user
     *
     * @param identityNumber: String
     *
     * @return boolean
     */
    public boolean existsUserByIdentityNumber(String identityNumber) {
        return this.userRepository.existsByIdentityNumber(identityNumber);
    }

}
