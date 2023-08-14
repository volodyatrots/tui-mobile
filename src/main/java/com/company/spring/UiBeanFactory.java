package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component("PageBeanFactory")
public class UiBeanFactory implements ApplicationContextAware {

    protected static ApplicationContext applicationContext;


    public static <T> T getBean(Class<T> page) {
        return applicationContext.getBean(page);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        UiBeanFactory.applicationContext = applicationContext;
    }
}
