package top.codewood.wx.common.util.xml;

import com.thoughtworks.xstream.converters.basic.StringConverter;

public class XStreamCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return String.format("<![CDATA[%s]]", super.toString(obj));
    }
}
