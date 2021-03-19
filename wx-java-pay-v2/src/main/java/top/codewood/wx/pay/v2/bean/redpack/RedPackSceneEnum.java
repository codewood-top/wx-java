package top.codewood.wx.pay.v2.bean.redpack;

public enum RedPackSceneEnum {

    PRODUCT_1("PRODUCT_1", "商品促销"),
    PRODUCT_2("PRODUCT_2", "抽奖"),
    PRODUCT_3("PRODUCT_3", "虚拟物品兑奖"),
    PRODUCT_4("PRODUCT_4", "企业内部福利"),
    PRODUCT_5("PRODUCT_5", "渠道分润"),
    PRODUCT_6("PRODUCT_6", "保险回馈"),
    PRODUCT_7("PRODUCT_7", "彩票派奖"),
    PRODUCT_8("PRODUCT_8", "税务刮奖");

    private String scene;
    private String name;

    RedPackSceneEnum(String scene, String name) {
        this.scene = scene;
        this.name = name;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
