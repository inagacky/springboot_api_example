package com.inagacky.api_sample_app.util.generator;

import java.util.UUID;

/**
 * トークン作成
 *
 */
public class SampleAppTokenGenerator {
    private SampleAppTokenGenerator(){}

    /**
     * トークン作成を行います。
     * @return
     */
    public static String generateToken() {

        return UUID.randomUUID().toString();
    }
}
