package com.future.basic.framework.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = { "com.future.basic.framework.**" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Configuration.class }) })
public class FutureBasicFrameworkConfiguration {
}
