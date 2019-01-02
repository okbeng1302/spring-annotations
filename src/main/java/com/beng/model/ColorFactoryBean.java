package com.beng.model;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个 Color 对象，注册到容器中
     */
    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 返回 true bean 单实例 false 多实例
     */
    public boolean isSingleton() {
        return false;
    }

}
