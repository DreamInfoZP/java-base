package com.zp;

import java.lang.reflect.Field;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ObjectConverter.java v1.0  2020/1/6 11:16 上午
 */
public class ObjectConverter {
    public static void parameterConvert(Object source, Object target) {
        Field[] s = source.getClass().getDeclaredFields();
        Field[] t = target.getClass().getDeclaredFields();
        Field newField;
        for (Field s1 : s) {
            for (Field t1 : t) {
                try {
                    if (s1.getName().toLowerCase().equals(t1.getName().replaceAll("_", "")) ||
                            s1.getName().replaceAll("_", "").equals(t1.getName().toLowerCase())) {
                        newField = target.getClass().getDeclaredField(t1.getName());
                        newField.setAccessible(true);
                        s1.setAccessible(true);
                        newField.set(target, s1.get(source));
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }
}
