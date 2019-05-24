package com.inagacky.api_sample_app.domain.service;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.exception.ValidationException;
import org.springframework.transaction.annotation.Transactional;

/**
 * User API Service
 *
 */
public interface UserService extends BaseService {

    /**
     * @param user
     *
     * @return
     */
    void create(User user) throws SampleSQLException;

    /**
     * @param userId
     *
     * @return
     */
    User findUser(Integer userId) throws ValidationException;

    /**
     * ユーザー情報の更新
     *
     * @param user
     *
     */
    @Transactional(rollbackFor = Exception.class)
    void update(User user) throws ValidationException, SampleSQLException;

    /**
     * @param userId
     *
     * @return
     */
    User delete(Integer userId) throws ValidationException, SampleSQLException;
}
