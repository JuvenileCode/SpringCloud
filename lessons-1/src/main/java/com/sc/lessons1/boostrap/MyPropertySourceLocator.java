package com.sc.lessons1.boostrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 {@link PropertySourceLocator} 实现
 *
 * @author Bin.l
 * @date 2018/6/4 19:35
 */
public class MyPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment = ConfigurableEnvironment.class.cast(environment);
            //获取PropertySources
            MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
            //定义一个新的PropertySource
            propertySources.addFirst(createPropertySource());
        }
        return null;
    }

    private PropertySource createPropertySource() {
        Map<String, Object> soruce = new HashMap<>();
        //spring.application.name 会覆盖掉**.properties配置
        soruce.put("spring.application.name", "Bin.Liu Spring Cloud Application test");
        PropertySource propertySource = new MapPropertySource("over-bootstrap-property-source", soruce);
        return propertySource;
    }
}
