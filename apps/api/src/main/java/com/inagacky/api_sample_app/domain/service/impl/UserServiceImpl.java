package com.inagacky.api_sample_app.domain.service.impl;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.service.UserService;
import com.inagacky.api_sample_app.domain.repository.sample.UserRepository;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
