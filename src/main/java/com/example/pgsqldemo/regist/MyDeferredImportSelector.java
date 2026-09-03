package com.example.pgsqldemo.regist;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String name = SystemConfig.class.getName();
        System.out.println("selectImports方法执行");
        return new String[0];
    }

    @Override
    public @Nullable Class<? extends Group> getImportGroup() {
        return  MyGroup.class;
    }


    public static class MyGroup  implements DeferredImportSelector.Group {



        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("MyGroup.process");
        }

        @Override
        public Iterable<Entry> selectImports() {
            List<Entry> entries = new ArrayList<>();
            return entries;
        }
    }
}
