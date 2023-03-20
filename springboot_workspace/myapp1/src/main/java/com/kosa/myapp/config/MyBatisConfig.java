package com.kosa.myapp.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// config 파일임을 명시하는 어노테이션
// 파일명과 클래스명은 내 마음대로 지어도 됨
@Configuration
public class MyBatisConfig {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
		
	@Bean	// 객체 생성 어노테이션
	public SqlSessionFactory makeSqlSessionFactory(DataSource dataSource) throws Exception {
		// SqlSessionFactory : Factory는 주로 MyBatis와 연동된 객체 생성을 전담하는 클래스들임
		// Factory 공장객체를 먼저 생성한다
		final SqlSessionFactoryBean FACTORY = new SqlSessionFactoryBean();
		
		// 이 factory 객체와 application.properties 파일에 있는 datasource를 연결
		FACTORY.setDataSource(dataSource);
		// 설정파일(mybatis-config.xml)과 연동
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		// classpath : src/main/resource
		Resource configLocation = resolver.getResource("classpath:mybatis-config.xml");
		FACTORY.setConfigLocation(configLocation);
		return FACTORY.getObject();
		
	}
	
	@Bean
	public SqlSessionTemplate makeSqlSession(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
	

}
