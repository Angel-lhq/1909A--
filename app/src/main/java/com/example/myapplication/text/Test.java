package com.example.myapplication.text;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        try {
//            //创建对象
//            Class<?> aClass = Class.forName("com.example.myapplication.text.Book");
//            Book book = (Book) aClass.newInstance();
//            book.setAuthor("aaaaaa");
//            book.setName("sssss");
//            System.out.println(book.toString());
//
//            //私有构造方法
//            Constructor<?> constructor = aClass.getDeclaredConstructor(String.class,String.class);
//            constructor.setAccessible(true);
//            Book book1 = (Book) constructor.newInstance("qqqqqq","wwwwwwww");
//            System.out.println(book1.toString());
//
//            // 反射私有方法(有参)
//            Method methodBook = aClass.getDeclaredMethod("declaredMethod",int.class);
//            methodBook.setAccessible(true);
//            String str = (String) methodBook.invoke(book,0);
//            System.out.println(str);
//
//            // 反射私有方法(无参)
//            Method methodBook1 = aClass.getDeclaredMethod("declaredMethod");
//            methodBook1.setAccessible(true);
//            String str1 = (String) methodBook1.invoke(book);
//            System.out.println(str1);
//
//
//            //反射私有属性
//            Field tag = aClass.getDeclaredField("TAG");
//            tag.setAccessible(true);
//            String tagBook = (String) tag.get(book);
//            System.out.println(tagBook);

            Integer integer = new Integer(111);
            //获取子类对象
            Class<?> mathBookClass = Class.forName("com.example.myapplication.text.MathBook");
            //获取子类继承的父类的类名
            Class<?> superclass = mathBookClass.getSuperclass();
            //获取父类对象
            Book o = (Book) superclass.newInstance();
            //获取父类中的私有属性
            Field tag = superclass.getDeclaredField("TAG");
            Method declaredMethod = superclass.getDeclaredMethod("declaredMethod", String.class);
            declaredMethod.invoke(o,"aaaaaaaaaaaa");
            //设置无阻碍访问
            tag.setAccessible(true);
            System.out.println(tag.get(o));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
