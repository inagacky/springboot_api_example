package com.inagacky.api_sample_app.domain.service.impl;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.service.UserService;
import com.inagacky.api_sample_app.domain.repository.sample.UserRepository;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * User API Service
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * ユーザー情報の作成
     *
     * @param user
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void create(User user) throws SampleSQLException {

        user.setInitData();
        userRepository.save(user);
    }

    /**
     * ユーザー情報の取得
     *
     * @param userId
     *
     */
    public User findUser(Integer userId) throws ValidationException {

        // ユーザー情報の取得
        var user = userRepository.findOneByUserId(userId);

        if (user == null) {
            String message = String.format("Not Exists Customer Error UserId:[%s]", userId);
            log.warn(message);
            ValidationException validationException = new ValidationException(message);
            throw validationException;
        }

        return user;
    }

    /**
     * ユーザー情報の更新
     *
     * @param user
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(User user) throws ValidationException, SampleSQLException {

        // ユーザー情報の取得
        this.findUser(user.getUserId());

        userRepository.update(user);
    }

    /**
     * @param userId
     *
     * @return
     */
    public User delete(Integer userId) throws ValidationException, SampleSQLException {
        // ユーザー情報の取得
        var user = this.findUser(userId);

        userRepository.delete(user);

        return user;
    }
}
