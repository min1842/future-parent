package com.future.basic.orm.datasource;

import java.util.function.Function;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.future.basic.orm.properties.FutureOrmProperties;

@Configuration
@ConditionalOnProperty(prefix = SecondDataSource.SECOND_DATASOURCE_PREFIX, name = "url")
@EnableTransactionManagement
@MapperScan(basePackages = "com.future.**.mapper.**", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSource {

	public static final String SECOND_DATASOURCE_PREFIX = "future.datasource.second";

	@Bean
	@ConfigurationProperties(prefix = SECOND_DATASOURCE_PREFIX, ignoreUnknownFields = true)
	public DruidDataSource secondDruidDataSource() {
		Supplier<DruidDataSource> secondDataSource = DruidDataSource::new;
		return secondDataSource.get();
	}

	@Bean
	@ConfigurationProperties(prefix = SECOND_DATASOURCE_PREFIX, ignoreUnknownFields = true)
	public FutureOrmProperties secondFutureOrmProperties() {
		return ((Supplier<FutureOrmProperties>) FutureOrmProperties::new).get();
	}

	@Bean
	public SqlSessionFactoryBean secondSqlSessionFactory(@Qualifier("secondDruidDataSource") DataSource datasource,
			@Qualifier("secondFutureOrmProperties") FutureOrmProperties futureOrmProperties) {
		futureOrmProperties.addMapperLocations("classpath*:mapper/**/oracle/*Mapper.xml");
		SqlSessionFactoryBean sqlsessionFactory = new SqlSessionFactoryBean();
		sqlsessionFactory.setConfiguration(futureOrmProperties.getConfig());
		sqlsessionFactory.setMapperLocations(futureOrmProperties.resolveMapperResource());
		sqlsessionFactory.setFailFast(true);
		return sqlsessionFactory;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(
			@Qualifier("secondDruidDataSource") DataSource dataSource) {
		return ((Function<DataSource, DataSourceTransactionManager>) DataSourceTransactionManager::new)
				.apply(dataSource);
	}
}
