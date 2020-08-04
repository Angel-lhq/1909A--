package com.example.myapplication.text1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.example.myapplication.text1.UserInfo");
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor constructor: constructors) {
                String name = constructor.getName();
                System.out.println(name);
            }

            TableName tableName = aClass.getAnnotation(TableName.class);
            System.out.println(tableName.tableName());
            Field name = aClass.getDeclaredField("name");
            ColumnName anName = name.getAnnotation(ColumnName.class);
            System.out.println(anName.columnName());
            Field id = aClass.getDeclaredField("id");
            ColumnName anId = id.getAnnotation(ColumnName.class);
            System.out.println(anId.columnName());
            Field apparence = aClass.getDeclaredField("apparence");
            ColumnName anApparence = apparence.getAnnotation(ColumnName.class);
            System.out.println(anApparence.columnName());



            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ColumnName.class)){
                    ColumnName c = field.getAnnotation(ColumnName.class);
                    String columnName = c.columnName();
                    System.out.println(columnName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
