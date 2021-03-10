package top.codewood.wx.common.util.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import java.io.Writer;

public class XStreamInitilizer {

    private static final XppDriver XPP_DRIVER;

    static {
        XPP_DRIVER = new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {

                    private Class clazz = null;

                    @Override
                    public void startNode(String name, Class clazz) {
                        this.clazz = clazz;
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (clazz == String.class) {
                            writer.write(String.format("<![CDATA[%s]]>", text));
                        } else {
                            super.writeText(writer, text);
                        }
                    }

                    @Override
                    public String encodeNode(String name) {
                        return name;// 防止将_转换成__
                    }
                };
            }
        };
    }

    public static XStream create() {
        XStream xStream = new XStream(XPP_DRIVER);

        xStream.ignoreUnknownElements();

        XStream.setupDefaultSecurity(xStream);
        xStream.addPermission(new WildcardTypePermission(new String[]{"top.codewood.**"}));
        return xStream;
    }

}
