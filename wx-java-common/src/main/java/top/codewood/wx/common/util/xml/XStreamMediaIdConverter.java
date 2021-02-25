package top.codewood.wx.common.util.xml;

public class XStreamMediaIdConverter extends XStreamCDataConverter {

    @Override
    public String toString(Object obj) {
        return String.format("<MediaId>%s</MediaId>", super.toString(obj));
    }
}
