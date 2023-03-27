package com.example.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@WebListener
public class MyListener implements ServletContextListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("-----------------"+"context 创建"+"------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("-----------------"+"context 销毁"+"------------------------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("-----------------"+"request 销毁"+"------------------------");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("-----------------"+"request 创建"+"------------------------");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("-----------------"+"request 属性 添加"+"------------------------");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("-----------------"+"request 属性 移除"+"------------------------");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("-----------------"+"request 属性 替换"+"------------------------");
    }
}
