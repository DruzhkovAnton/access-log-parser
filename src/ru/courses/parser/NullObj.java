package ru.courses.parser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NullObj {
    public static void setNullFilds(Object obj) throws NoSuchFieldException {

        List<Field> filds = List.of(obj.getClass().getDeclaredFields());
        System.out.println(filds.toString());

        for(Field field : filds) {
            field.setAccessible(true);
            try {
                field.set(obj, null);
                System.out.println(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        }
        System.out.println(filds.toString());
    }

}
