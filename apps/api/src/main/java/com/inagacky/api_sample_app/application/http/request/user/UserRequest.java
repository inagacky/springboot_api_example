package com.inagacky.api_sample_app.application.http.request.user;

import com.inagacky.api_sample_app.application.http.request.AbstractApiRequest;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserRequest extends AbstractApiRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
