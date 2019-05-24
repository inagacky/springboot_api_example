package com.inagacky.api_sample_app.presentation.http.request.user;

import com.inagacky.api_sample_app.presentation.http.request.AbstractApiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateUserRequest extends AbstractApiRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;
}
