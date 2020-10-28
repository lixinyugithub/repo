package com.nbteam.hislite.lhrm.config.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
//属性不存在默认设置 true
public class DataSourceConfig {
	/****
	 * 
	* @Title: hisliteDataSource 
	* @Description: 数据源配置
	* @param   输入参数
	* @return DataSource    返回类型 
	* @throws
	 */
    @Bean(name = "hisliteDataSource")
    @Qualifier("hisliteDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hislite")
    public DataSource hisliteDataSource() {
        return DataSourceBuilder.create().build();
    }
    /****
     * 
    * @Title: hisliteJdbcTemplate 
    * @Description: 数据连接tempp
    * @param   输入参数
    * @return JdbcTemplate    返回类型 
    * @throws
     */
    @Bean(name = "hisliteJdbcTemplate")
    public JdbcTemplate hisliteJdbcTemplate(
            @Qualifier("hisliteDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}