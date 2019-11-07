package com.future.basic.orm.datasource;

import java.util.function.Supplier;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.future.basic.orm.properties.FutureOrmProperties;

@Configuration
@ConditionalOnProperty(prefix = PrimaryDataSource.FUTURE_PROPERTIES_PREFIX, name = "url")
@EnableTransactionManagement
@MapperScan(basePackages = "com.future.**.mapper.**", sqlSessionFactoryRef = "primarySqlsessionFactory")
public class PrimaryDataSource {

	public static final String FUTURE_PROPERTIES_PREFIX = "future.datasource.primary";

	@Bean
	@Primary
	@ConfigurationProperties(prefix = FUTURE_PROPERTIES_PREFIX)
	public DruidDataSource primaryDruidDataSource() {
		Supplier<DruidDataSource> dataSourceSupplier = DruidDataSource::new;
		return dataSourceSupplier.get();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = FUTURE_PROPERTIES_PREFIX)
	public FutureOrmProperties primaryFutureOrmProperties() {
		Supplier<FutureOrmProperties> futureOrmPropertiesSupplier = FutureOrmProperties::new;
		return futureOrmPropertiesSupplier.get();
	}

	@Bean
	@Primary
	public SqlSessionFactoryBean primarySqlsessionFactory(@Qualifier("primaryDruidDataSource") DataSource dataSource,
			@Qualifier("primaryFutureOrmProperties") FutureOrmProperties futureOrmProperties) {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setConfiguration(futureOrmProperties.getConfig());
		sqlSessionFactory.setMapperLocations(futureOrmProperties.resolveMapperResource());
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setFailFast(true);
		return sqlSessionFactory;
	}

	@Bean
	@Primary
	public DataSourceTransactionManager dataSourceTransactionManager(
			@Qualifier("primaryDruidDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// @Bean
	// @Primary
	// public SqlSessionTemplate primarySqlSessionTemplate(
	// @Qualifier("primarySqlSessionFactory") SqlSessionFactory
	// primarySqlSessionFactory) {
	// return new SqlSessionTemplate(primarySqlSessionFactory);
	// }

}
