package com.koc.finans.api.service.model.repo;

import com.koc.finans.api.service.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>, JpaSpecificationExecutor<UserModel> {

     Optional<UserModel> findUserModelByIdentityNumber(String identityNumber);

     boolean existsByIdentityNumber(String identityNumber);

}
