package com.nbteam.hislite.payment.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.nbteam.hislite.payment.*.*.mapper"}, sqlSessionTemplateRef = "hisliteSqlSessionTemplate")
public class HisliteMybatisConfig {

    @Bean(name="hisliteSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hisliteDataSource") DataSource hisliteDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(hisliteDataSource); // 使用titan数据源, 连接titan库
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:com/nbteam/hislite/**/mybatis/*Mapper.xml"));//指定xml文件位置
        return factoryBean.getObject();
    }
    
    @Bean(name = "hisliteTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("hisliteDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name="hisliteSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateBscl(@Qualifier("hisliteSqlSessionFactory") SqlSessionFactory hisliteSqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(hisliteSqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}