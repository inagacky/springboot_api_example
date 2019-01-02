package com.inagacky.api_sample_app.infrastructure.repository.impl.sample;

import com.inagacky.api_sample_app.domain.repository.sample.BaseSampleRepository;
import com.inagacky.api_sample_app.infrastructure.repository.impl.BaseRepositoryImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public class BaseSampleRepositoryImpl extends BaseRepositoryImpl implements BaseSampleRepository {

    @Autowired
    @Qualifier("sampleSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
