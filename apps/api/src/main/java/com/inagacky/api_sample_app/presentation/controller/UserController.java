package com.inagacky.api_sample_app.presentation.controller;

import com.inagacky.api_sample_app.exception.ValidationException;
import com.inagacky.api_sample_app.presentation.http.request.user.UpdateUserRequest;
import com.inagacky.api_sample_app.presentation.http.request.user.UserRequest;
import com.inagacky.api_sample_app.presentation.http.response.IApiResponseResult;
import com.inagacky.api_sample_app.presentation.http.response.user.UserResponse;
import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.service.UserService;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.util.constants.ApiRoutingConstants;
import com.inagacky.api_sample_app.presentation.mapper.EntityMapper;
import com.inagacky.api_sample_app.presentation.mapper.ResponseResultMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * User API Controller
 *
 */
@RestController
@RequestMapping(value= ApiRoutingConstants.API_BASE_PATH, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class UserController extends AbstractApiController {

    @Autowired
    private UserService userService;

    /**
     * ユーザー作成
     *
     * @param userRequest
     */
    @PostMapping(value = ApiRoutingConstants.VERSION_1_0+ApiRoutingConstants.USERS_PATH)
    public IApiResponseResult create(@RequestBody @Validated UserRequest userRequest) throws SampleSQLException {

        // リクエストモデルをエンティティに変換
        var user = EntityMapper.mappingToEntity(userRequest, User.class);

        userService.create(user);

        // エンティティをレスポンスモデルに変換　
        UserResponse userResponse = ResponseResultMapper.mappingToResponseResult(user, UserResponse.class);

        return userResponse;
    }

    /**
     * ユーザー取得
     *
     * @param userId
     */
    @GetMapping(value = ApiRoutingConstants.VERSION_1_0+ApiRoutingConstants.USERS_PATH+ApiRoutingConstants.PARAMETER_USERID_PATH)
    public IApiResponseResult findUser(@PathVariable("userId") Integer userId) throws ValidationException {

        var user = userService.findUser(userId);

        // エンティティをレスポンスモデルに変換
        UserResponse userResponse = ResponseResultMapper.mappingToResponseResult(user, UserResponse.class);

        return userResponse;
    }

    /**
     * ユーザー更新
     *
     * @param userId
     * @param updateUserRequest
     *
     */
    @PutMapping(value = ApiRoutingConstants.VERSION_1_0+ApiRoutingConstants.USERS_PATH+ApiRoutingConstants.PARAMETER_USERID_PATH)
    public IApiResponseResult update(@PathVariable("userId") Integer userId, @RequestBody @Validated UpdateUserRequest updateUserRequest) throws ValidationException, SampleSQLException {

        // リクエストモデルを変換
        var user = EntityMapper.mappingToEntity(updateUserRequest, User.class);
        user.setUserId(userId);

        userService.update(user);

        // エンティティをレスポンスモデルに変換
        UserResponse userResponse = ResponseResultMapper.mappingToResponseResult(user, UserResponse.class);

        return userResponse;

    }

    /**
     * ユーザー削除
     *
     * @param userId
     *
     */
    @DeleteMapping(value = ApiRoutingConstants.VERSION_1_0+ApiRoutingConstants.USERS_PATH+ApiRoutingConstants.PARAMETER_USERID_PATH)
    public IApiResponseResult update(@PathVariable("userId") Integer userId) throws ValidationException, SampleSQLException {

        var user = userService.delete(userId);

        // エンティティをレスポンスモデルに変換
        UserResponse userResponse = ResponseResultMapper.mappingToResponseResult(user, UserResponse.class);

        return userResponse;

    }
}
