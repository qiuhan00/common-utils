package com.cfang.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import cn.hutool.core.lang.Assert;

/**
 * @description 
 * @author cfang 2020年9月1日
 */
@Component
public class SpringContextUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}
	
	public static void clearHolder() {
		applicationContext = null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) getContext().getBean(name);
	}
	
	public static <T> T getBean(Class<T> cls) {
		assertContextInjected();
		return (T) getContext().getBean(cls);
	}
	
	private static void assertContextInjected(){
		Assert.notNull(applicationContext, "applicationContext未注入！", new Object());
	}

}
