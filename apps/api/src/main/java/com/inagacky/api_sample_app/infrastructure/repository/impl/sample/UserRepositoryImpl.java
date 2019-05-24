package com.inagacky.api_sample_app.infrastructure.repository.impl.sample;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.repository.sample.UserRepository;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.exception.ValidationException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
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

    /**
     * ユーザー情報の取得処理
     *
     * @param userId
     *
     */
    public User findOneByUserId(@NotNull Integer userId) {

        // 条件設定
        Map condition = new HashMap<String, Integer>() {
            {
                put("userId", userId);
            }
        };

        User user = getSqlSessionTemplate().selectOne(
                "UserRepository.findOneByUserId", condition);

        return user;
    }


    /**
     * ユーザー情報を更新します。
     *
     * @param user
     *
     */
    public void update(@NotNull User user) throws SampleSQLException, ValidationException {

        int updatedCnt;

        try {
            updatedCnt = getSqlSessionTemplate().update(
                    "UserRepository.update", user);

        } catch (Exception e) {
            log.error("ユーザー情報の更新処理でエラーが発生しました。", e);
            throw new SampleSQLException("ユーザー情報の更新処理でエラーが発生しました。", e);
        }

        if (updatedCnt == 0) {
            String message = String.format("ユーザー情報の更新処理結果が0件です。 user:[%s]", user);
            log.error(message);
            throw new ValidationException("ユーザー情報の更新処理結果が0件です。");
        }
    }

    /**
     * ユーザー情報を削除します。
     *
     * @param user
     *
     */
    public void delete(@NotNull User user) throws SampleSQLException, ValidationException {

        int deletedCnt;

        user.setStatus(User.Status.INVALID);

        try {
            deletedCnt = getSqlSessionTemplate().update(
                    "UserRepository.delete", user);

        } catch (Exception e) {
            log.error("ユーザー情報の削除処理でエラーが発生しました。", e);
            throw new SampleSQLException("ユーザー情報の削除処理でエラーが発生しました。", e);
        }

        if (deletedCnt == 0) {
            String message = String.format("ユーザー情報の削除処理結果が0件です。 user:[%s]", user);
            log.error(message);
            throw new ValidationException("ユーザー情報の削除処理結果が0件です。");
        }
    }
}
