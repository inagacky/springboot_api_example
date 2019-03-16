package com.inagacky.api_sample_app.application.controller;

import com.inagacky.api_sample_app.application.http.request.user.UserRequest;
import com.inagacky.api_sample_app.application.http.response.IApiResponseResult;
import com.inagacky.api_sample_app.application.http.response.user.UserResponse;
import com.inagacky.api_sample_app.configure.annotation.NonAuth;
import com.inagacky.api_sample_app.domain.entity.sample.User;
import com.inagacky.api_sample_app.domain.service.UserService;
import com.inagacky.api_sample_app.exception.IllegalDataException;
import com.inagacky.api_sample_app.exception.SampleSQLException;
import com.inagacky.api_sample_app.util.constants.ApiRoutingConstants;
import com.inagacky.api_sample_app.application.mapper.EntityMapper;
import com.inagacky.api_sample_app.application.mapper.ResponseResultMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param userRequest
     */
    @NonAuth
    @PostMapping(value = ApiRoutingConstants.VERSION_1_0+ApiRoutingConstants.USERS_PATH)
    public IApiResponseResult create(@RequestBody @Validated UserRequest userRequest) throws SampleSQLException, IllegalDataException {

        // リクエストモデルをエンティティに変換
        User user = EntityMapper.<UserRequest, User>mappingToEntity(userRequest, User.class);

        userService.create(user);

        // エンティティをレスポンスモデルに変換　
        UserResponse userResponse = ResponseResultMapper.<User, UserResponse>mappingToResponseResult(user, UserResponse.class);

        return userResponse;
    }

}
