package com.inagacky.api_sample_app.presentation.mapper;

import com.inagacky.api_sample_app.presentation.http.request.AbstractApiRequest;
import com.inagacky.api_sample_app.domain.entity.BaseEntity;

/**
 * Entity Mapper
 */
public class EntityMapper extends BaseMapper
{
    private EntityMapper(){}

    /**
     *
     * @param fromApiRequestModel
     * @param entityClass
     * @param <gApiRequestmodel>
     * @param <gEntity>
     * @return
     */
    public static <gApiRequestmodel extends AbstractApiRequest, gEntity extends BaseEntity> gEntity mappingToEntity(gApiRequestmodel fromApiRequestModel, Class<gEntity> entityClass) {

        gEntity mapEntity = getModelMapper().map(fromApiRequestModel, entityClass);

        return mapEntity;
    }
}
