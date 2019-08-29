package com.linjingc.simpleatomikosdemo.mybaitisconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.linjingc.simpleatomikosdemo.dao1", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class OneDatabaseConfig {

	@Bean(name = "oneDataSource")
	@ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.test1")
	public DataSource oneDataSource() {
		return new AtomikosDataSourceBean();
	}

	@Bean(name = "oneSqlSessionFactory")
	public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(oneDataSource);
		return bean.getObject();
	}
}