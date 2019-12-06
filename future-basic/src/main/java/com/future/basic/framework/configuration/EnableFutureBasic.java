package com.future.basic.framework.configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 开启扫描基础功能，默认会扫描包com.future.basic.framework下的@Component组件
 * @author hzhang
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FutureBasicRegistrar.class)
public @interface EnableFutureBasic {

}
