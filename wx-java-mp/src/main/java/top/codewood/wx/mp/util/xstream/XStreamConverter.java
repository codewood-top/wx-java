package top.codewood.wx.mp.util.xstream;

import com.thoughtworks.xstream.XStream;

import java.io.InputStream;
import java.util.*;

public class XStreamConverter {

    private static final Map<Class<?>, XStream> XSTREAM_INSTANCES = new HashMap<>();

    private static void registerClass(Class<?> clz, XStream xStream) {
        XSTREAM_INSTANCES.put(clz, xStream);
    }

    public static <T> T fromXml(Class<T> clz, String xml) {
        return (T) getXStream(clz).fromXML(xml);
    }

    public static <T> T fromXml(Class<T> clz, InputStream is) {
        return (T) getXStream(clz).fromXML(is);
    }

    public static <T> String toXml(T obj) {
        return getXStream(obj.getClass()).toXML(obj);
    }

    private static XStream getXStream(Class<?> clz) {
        return XSTREAM_INSTANCES.getOrDefault(clz, registerClass(clz));
    }

    public static XStream registerClass(Class<?> clz) {
        XStream xStream = XSTREAM_INSTANCES.get(clz);

        if (xStream != null) return xStream;

        xStream = XStreamInitilizer.create();
        xStream.processAnnotations(clz);
        xStream.processAnnotations(getInnerClass(clz));

        registerClass(clz, xStream);

        return xStream;
    }

    private static Class<?>[] getInnerClass(Class<?> clz) {
        Class<?>[] innerClasses = clz.getClasses();
        if (innerClasses == null) return null;

        List<Class<?>> classes = new ArrayList<>();
        classes.addAll(Arrays.asList(innerClasses));

        for (Class<?> c : innerClasses) {
            Class<?>[] inInnerClasses = getInnerClass(c);
            if (inInnerClasses == null) continue;
            classes.addAll(Arrays.asList(inInnerClasses));
        }

        return innerClasses;
    }

}
