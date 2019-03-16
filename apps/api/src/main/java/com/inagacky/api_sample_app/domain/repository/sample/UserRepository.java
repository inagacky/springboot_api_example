package com.inagacky.api_sample_app.domain.repository.sample;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.exception.SampleSQLException;


/**
 * User Repository
 *
 */
public interface UserRepository extends BaseSampleRepository {

    /**
     * ユーザー情報の作成
     *
     * @param user
     *
     */
    void save(User user) throws SampleSQLException;
}
