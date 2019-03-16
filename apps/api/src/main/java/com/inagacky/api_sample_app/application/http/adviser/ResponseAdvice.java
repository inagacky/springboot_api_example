package com.inagacky.api_sample_app.application.http.adviser;

import com.inagacky.api_sample_app.application.http.response.ApiResponse;
import com.inagacky.api_sample_app.application.http.response.IApiResponseResult;
import com.inagacky.api_sample_app.application.http.response.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * レスポンスに対するアドバイザ　
 */
@ControllerAdvice
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * レスポンスの形式を変換
     * 　
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        ApiResponse apiResponse = new ApiResponse();
        if (body instanceof IApiResponseResult) {

            apiResponse.setStatusCode(ApiResponse.StatusCode.VALID);
            apiResponse.setResult((IApiResponseResult) body);
        } else if (body instanceof ErrorResponse) {

            apiResponse.setStatusCode(ApiResponse.StatusCode.INVALID);
            apiResponse.setErrorResponse((ErrorResponse) body);
        } else {

            apiResponse.setStatusCode(ApiResponse.StatusCode.INVALID);
        }

        return apiResponse;
    }
}
