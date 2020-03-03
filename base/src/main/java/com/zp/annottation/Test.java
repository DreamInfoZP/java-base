package com.zp.annottation;

import cn.hutool.core.util.ObjectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author zhoupeng
 * @date Test.java v1.0  2019/12/19 9:01 下午
 */
public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("lucy");

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zhou@163.com,peng@qq.com");

        Filter f4 = new Filter();
        f4.setId(0);

        System.out.println(query(f1));
        System.out.println(query(f2));
        System.out.println(query(f3));
        System.out.println(query(f4));
    }

    public static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        Class c = f.getClass();
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnValue = column.value();
            String columnName = field.getName();
            String getMethodName = "get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);

            Object filedValue = null;
            try {
                Method method = c.getMethod(getMethodName);
                filedValue = method.invoke(f);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (ObjectUtil.isNotNull(filedValue)) {
                sb.append(" and ");
                if (filedValue instanceof String) {
                    if (((String) filedValue).contains(",")) {
                        String[] split = ((String) filedValue).split(",");
                        sb.append(columnName).append(" in(");
                        for (String s : split) {
                            sb.append("'" + s + "',");
                        }
                        sb.deleteCharAt(sb.length()-1).append(")");
                    } else {
                        sb.append(columnValue).append(" = ").append("'" + filedValue + "'");
                    }
                } else {
                    sb.append(columnValue).append(" = ").append(filedValue);

                }
            }
        }
        return sb.toString();
    }
}
