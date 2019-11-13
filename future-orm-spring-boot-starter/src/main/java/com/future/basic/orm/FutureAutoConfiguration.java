package com.future.basic.orm;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.future.basic.orm.properties.PageHelperProperties;

/**
 * AutoConfigureBefore/After 的类必须在spring.factories文件中，原理就是排序autoconfig顺序，
 * 有文章称ComponentScan会使排序（After/Before）失效, 未实践。 ConditionalOnProperties
 * 不能配置父类属性，不然永远Not Match
 * 
 * @author hzhang
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.future.basic.orm.datasource" })
@EnableConfigurationProperties(PageHelperProperties.class)
//@Import(value = { PrimaryDataSource.class, SecondDataSource.class })
@AutoConfigureBefore(PageHelperConfiguration.class)
public class FutureAutoConfiguration {

}
