package top.codewood.wx.mnp.bean.operation;

public enum WxMnpFeedbackType {

    TYPE_1(1, "无法打开小程序"),
    TYPE_2(2, "小程序闪退"),
    TYPE_3(3, "卡顿"),
    TYPE_4(4, "黑屏白屏"),
    TYPE_5(5, "死机"),
    TYPE_6(6, "界面错位"),
    TYPE_7(7, "界面加载慢"),
    TYPE_8(8, "其他异常");
    private int type;
    private String name;

    WxMnpFeedbackType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
