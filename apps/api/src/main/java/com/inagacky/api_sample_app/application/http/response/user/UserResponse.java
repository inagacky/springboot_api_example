package com.inagacky.api_sample_app.application.http.response.user;

import com.inagacky.api_sample_app.application.http.response.BaseApiResponseResult;
import com.inagacky.api_sample_app.domain.entity.sample.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserResponse extends BaseApiResponseResult {

    private Integer userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private User.Status status;

}
