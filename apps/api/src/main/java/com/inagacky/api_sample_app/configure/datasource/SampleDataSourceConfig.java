package com.inagacky.api_sample_app.configure.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SampleDataSourceConfig {
    public static final String MAPPER_XML_PATH = "classpath:com/inagacky/api_sample_app/infrastructure/repository/sample/*.xml";
    public static final String CONFIG_XML_PATH = "classpath:mybatis-config.xml";

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.sample")
    public DataSourceProperties sampleProperties() {

        return new DataSourceProperties();
    }

    @Bean(name = {"sampleDataSource"})
    @Primary
    public DataSource sampleDataSource(
            @Qualifier("sampleProperties") DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = {"sampleTransactionManager"})
    @Primary
    public PlatformTransactionManager sampleTransactionManager(DataSource dataSource1) {
        return new DataSourceTransactionManager(dataSource1);
    }

    @Bean(name = "sampleSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sampleDataSource") DataSource primaryDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(primaryDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(CONFIG_XML_PATH));

        return bean.getObject();
    }

    @Bean(name = "sampleSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sampleSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
