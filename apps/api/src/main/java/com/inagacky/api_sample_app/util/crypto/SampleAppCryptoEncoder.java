package com.inagacky.api_sample_app.util.crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 暗号化処理
 *
 */
@Component
public class SampleAppCryptoEncoder {
    private SampleAppCryptoEncoder(){}

    private static PasswordEncoder staticPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * PasswordEncoderのインスタンス初期化
     */
    @PostConstruct
    public void init() {
        SampleAppCryptoEncoder.staticPasswordEncoder = passwordEncoder;
    }

    /**
     * BCryptによる暗号化を行います。
     * @param password パスワード
     * @return ハッシュ値
     */
    public static String encrypt(String password) {

        return staticPasswordEncoder.encode(password);
    }


    /**
     * BCryptの照合を行います。
     * @param password パスワード
     * @param digest ハッシュ値
     * @return
     */
    public static boolean matches(String password, String digest) {

        return staticPasswordEncoder.matches(password, digest);
    }
}
