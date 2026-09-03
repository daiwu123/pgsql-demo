package com.example.pgsqldemo.regist;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyRegisterConfig implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String[] array = new MyPackageImports(importingClassMetadata).getPackageNames().toArray(new String[0]);
        registry.registerBeanDefinition("myregister", new RootBeanDefinition(MyRegister.class));
        registry.registerBeanDefinition("MyWorker", new RootBeanDefinition(MyWorker.class));
    }


    private static final class MyPackageImports {

        private final List<String> packageNames;

        MyPackageImports(AnnotationMetadata metadata) {
            AnnotationAttributes attributes = AnnotationAttributes
                    .fromMap(metadata.getAnnotationAttributes(AutoConfigurationPackage.class.getName(), false));
            Assert.state(attributes != null, "'attributes' must not be null");
            List<String> packageNames = new ArrayList<>(Arrays.asList(attributes.getStringArray("basePackages")));
            for (Class<?> basePackageClass : attributes.getClassArray("basePackageClasses")) {
                packageNames.add(basePackageClass.getPackage().getName());
            }
            if (packageNames.isEmpty()) {
                packageNames.add(ClassUtils.getPackageName(metadata.getClassName()));
            }
            this.packageNames = Collections.unmodifiableList(packageNames);
        }

        List<String> getPackageNames() {
            return this.packageNames;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.packageNames.equals(((MyPackageImports) obj).packageNames);
        }

        @Override
        public int hashCode() {
            return this.packageNames.hashCode();
        }

        @Override
        public String toString() {
            return "Package Imports " + this.packageNames;
        }

    }
}
