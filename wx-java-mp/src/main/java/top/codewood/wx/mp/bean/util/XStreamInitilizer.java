package top.codewood.wx.mp.bean.util;

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

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        writer.write(String.format("<![CDATA[%s]]", text));
                    }
                };
            }
        };
    }

    public static XStream create() {
        XStream xStream = new XStream(XPP_DRIVER);
        XStream.setupDefaultSecurity(xStream);
        xStream.addPermission(new WildcardTypePermission(new String[]{"top.codewood.**"}));
        return xStream;
    }

}
