package com.sc.lessons1.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring事件/监听器 Demo
 *
 * @author: dota.liu.bin@gmail.com
 * @date: 2018-05-29 14:06
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //增加监听器
        context.addApplicationListener(new MyApplicationListener());
        // 上下文启动
        context.refresh();
        //发布事件
        context.publishEvent(new MyApplicationEvent("Hello,World-1"));
        context.publishEvent(new MyApplicationEvent("Hello,World-2"));
        context.publishEvent(new MyApplicationEvent("Hello,World-3"));
    }

    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.println(" MyApplicationListener receives event : "+event.getSource());
        }
    }

    private static class MyApplicationEvent extends ApplicationEvent {

        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
