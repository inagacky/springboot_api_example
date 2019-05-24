package com.inagacky.api_sample_app.domain.repository.sample;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.exception.ValidationException;


/**
 * User Repository
 *
 */
public interface UserRepository extends BaseSampleRepository {

    /**
     * ユーザー情報の作成します。
     *
     * @param user
     *
     */
    void save(User user) throws SampleSQLException;

    /**
     * ユーザー情報の取得します。
     *
     * @param userId
     *
     */
    User findOneByUserId(Integer userId);

    /**
     * ユーザー情報を更新します。
     *
     * @param user
     *
     */
    void update(User user) throws SampleSQLException, ValidationException;


    /**
     * ユーザー情報を削除します。
     *
     * @param user
     *
     */
    void delete(User user) throws SampleSQLException, ValidationException;
}
