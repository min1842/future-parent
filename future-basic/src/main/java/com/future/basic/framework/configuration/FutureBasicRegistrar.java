package com.future.basic.framework.configuration;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

public class FutureBasicRegistrar implements ImportBeanDefinitionRegistrar {

	private static final String DEFAULT_SCAN_PACKAGE = "com.future.basic.framework";

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
		scanner.addIncludeFilter(
				(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) -> metadataReader
						.getAnnotationMetadata().isAnnotated(Component.class.getSimpleName()));
		scanner.scan(DEFAULT_SCAN_PACKAGE);
	}

}
