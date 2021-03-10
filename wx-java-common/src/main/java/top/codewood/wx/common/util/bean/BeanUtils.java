package top.codewood.wx.common.util.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.annotation.Required;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {

    public static void checkRequiredFields(Object bean) {
        assert bean != null;
        List<String> nullFields = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.addAll(getClassFields(bean.getClass()));

        for (Field field : fields) {
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(Required.class) && field.get(bean) == null) {
                    nullFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(accessible);
        }

        if (!nullFields.isEmpty()) {
            throw new RuntimeException("必填字段：" + String.join(",", nullFields));
        }


    }

    public static List<Field> getClassFields(Class<?> clazz) {
        if (clazz == null) return Collections.EMPTY_LIST;
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        fields.addAll(getClassFields(clazz.getSuperclass()));
        return fields;
    }

    public static Map<String, Object> xmlBean2Map(Object bean) {
        assert bean != null;
        Map<String, Object> map = new HashMap<>();

        List<Field> fields = getClassFields(bean.getClass());

        for (Field field : fields) {
            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(bean);
                    if (fieldValue == null) {
                        continue;
                    }
                if (field.isAnnotationPresent(XStreamAlias.class)) {
                    map.put(field.getAnnotation(XStreamAlias.class).value(), fieldValue);
                } else {
                    map.put(field.getName(), fieldValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(accessible);
                continue;
            }
        }

        return map;
    }

}
