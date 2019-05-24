package com.inagacky.api_sample_app.presentation.mapper;

import com.inagacky.api_sample_app.presentation.http.response.IApiResponseResult;
import com.inagacky.api_sample_app.domain.entity.BaseEntity;

/**
 * ResponseResult Mapper
 */
public class ResponseResultMapper extends BaseMapper
{
    private ResponseResultMapper(){}

    /**
     *
     * @return
     */
    public static <gEntity extends BaseEntity, gApiResponseResult extends IApiResponseResult> gApiResponseResult mappingToResponseResult(gEntity entity, Class<gApiResponseResult> apiResponseResultClass) {

        gApiResponseResult apiResponseResult = getModelMapper().map(entity, apiResponseResultClass);

        return apiResponseResult;
    }

}
