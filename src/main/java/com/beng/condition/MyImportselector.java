package com.beng.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义逻辑返回需要导入的组件
public class MyImportselector implements ImportSelector {

    // AnnotationMetadata： 当前标注 @Import 注解类的所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 方法不要返回null值
        return new String[] { "com.beng.model.Color", "com.beng.model.Red", "com.beng.model.Blue" };
    }

}
