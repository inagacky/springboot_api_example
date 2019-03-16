package com.inagacky.api_sample_app.infrastructure.repository.impl.sample;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.repository.sample.UserRepository;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class UserRepositoryImpl extends BaseSampleRepositoryImpl implements UserRepository {

    /**
     * ユーザー情報の保存処理　
     *
     * @param user
     *
     */
    public void save(@NonNull User user) throws SampleSQLException {

        int insertedCnt;

        try {
            insertedCnt = getSqlSessionTemplate().insert(
                    "UserRepository.save", user);
            
        } catch (Exception e) {
            log.error("An error occurred during registration of user information", e);
            throw new SampleSQLException("An error occurred during registration of user information", e);
        }

        if (insertedCnt == 0) {
            log.error("The result of user information registration is 0", user);
            throw new SampleSQLException("The result of user information registration is 0");
        }
    }
}
