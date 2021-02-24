package top.codewood.wx.mp.bean.menu;

import top.codewood.wx.common.util.json.WxGsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxMenu implements Serializable {

    private List<WxMenuButton> buttons = new ArrayList<>();

    private WxMenuRule matchRule;

    public List<WxMenuButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<WxMenuButton> buttons) {
        this.buttons = buttons;
    }

    public WxMenuRule getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(WxMenuRule matchRule) {
        this.matchRule = matchRule;
    }

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

}
