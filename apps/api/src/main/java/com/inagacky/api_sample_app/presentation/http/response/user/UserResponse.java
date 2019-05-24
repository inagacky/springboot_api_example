package com.inagacky.api_sample_app.presentation.http.response.user;

import com.inagacky.api_sample_app.presentation.http.response.BaseApiResponseResult;
import com.inagacky.api_sample_app.domain.entity.sample.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends BaseApiResponseResult {

    private Integer userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String  email;

    @NotNull
    private User.Status status;

}
