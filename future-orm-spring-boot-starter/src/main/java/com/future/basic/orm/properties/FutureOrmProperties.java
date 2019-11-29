package com.future.basic.orm.properties;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.ibatis.session.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 配置文件
 * 
 * @author hzhang
 *
 */
@Getter
@Setter
@Slf4j
public class FutureOrmProperties {

	private static final PathMatchingResourcePatternResolver PATH_RESOLVER = new PathMatchingResourcePatternResolver();

	private Configuration config;

	private String[] mapperLocations;

	public Resource[] resolveMapperResource() {
		return Stream.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]))
				.flatMap(this::getResourcesStreamFromMapperLocation).toArray(Resource[]::new);
	}

	private Stream<Resource> getResourcesStreamFromMapperLocation(String mapperLocation) {
		try {
			return Stream.of(PATH_RESOLVER.getResources(mapperLocation));
		} catch (IOException e) {
			log.error("Load Mapper Resource Error.", e);
		}
		return Stream.empty();
	}

	public void addMapperLocations(@NonNull String... mapperLocations) {
		this.mapperLocations = Stream
				.of(Optional.ofNullable(this.mapperLocations).orElse(new String[0]), mapperLocations)
				.flatMap(Stream::of).toArray(String[]::new);
	}
}
