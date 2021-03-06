package com.inagacky.api_sample_app.domain.entity.sample;

import com.fasterxml.jackson.annotation.JsonValue;
import com.inagacky.api_sample_app.util.crypto.SampleAppCryptoEncoder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * User
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseSampleEntity {

    public enum Status {
        VALID(1),
        INVALID(9)
        ;
        private final int id;

        Status(final int id) {
            this.id = id;
        }

        @JsonValue
        public int getInt() {
            return this.id;
        }

        public static Status fromId(int id) {

            return Arrays.stream(Status.values())
                    .filter(status -> status.getInt() == id)
                    .findFirst().orElse(null);
        }
    }

    private Integer userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Status status;

    @NotNull
    private String email;

    @NotNull
    private String password;

    /**
     * ユーザー作成時の初期データ　
     */
    public void setInitData() {
        this.setPassword(SampleAppCryptoEncoder.encrypt(this.getPassword()));
        this.setStatus(User.Status.VALID);
    }
}
