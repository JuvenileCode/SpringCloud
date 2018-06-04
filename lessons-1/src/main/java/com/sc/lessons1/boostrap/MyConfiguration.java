package com.sc.lessons1.boostrap;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Bootstrap 配置 Bean
 *
 * @author Bin.l
 * @date 2018/6/4 19:03
 */
@Configurable
public class MyConfiguration implements ApplicationContextInitializer{

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        //获取PropertySources
        MutablePropertySources propertySources = environment.getPropertySources();
        //定义一个新的PropertySource
        propertySources.addFirst(createPropertySource());
    }

    private PropertySource createPropertySource() {
        Map<String, Object> soruce = new HashMap<>();
        soruce.put("name", "Bin.Liu");
        PropertySource propertySource = new MapPropertySource("my-property-source", soruce);
        return propertySource;
    }
}
