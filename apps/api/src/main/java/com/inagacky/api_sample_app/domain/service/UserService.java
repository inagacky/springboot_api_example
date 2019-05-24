package com.inagacky.api_sample_app.domain.service;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.exception.SampleSQLException;

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
}
