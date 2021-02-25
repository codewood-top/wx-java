package top.codewood.wx.mp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import top.codewood.wx.common.util.json.WxGsonBuilder;
import top.codewood.wx.mp.api.WxMpApi;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.bean.menu.WxMenuButton;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WxJavaSpringBootApplication.class)
public class WxMenuTest {

    //@Autowired
    private WxMpApi wxMpService;

    static String accessToken = "42_taVuNbmp2eYquQ6dx1DazYBBTy3OxMriH5eLLzeN83hBfBSTyKaeO5JS76bgcXMEpNAM2fz28hGB626oljKnIQOmFXgrksZMc_zZ5QkfZSYkIJqywwcQEp2YGZwGhMko5t7N-SIle3XtAslvRAWhADAGPL";

    @Test
    public void createMenu() {

        WxMenu wxMenu = new WxMenu();

        List<WxMenuButton> buttons = new ArrayList<>();

        WxMenuButton button_click = new WxMenuButton();
        button_click.setType("click");
        button_click.setName("点击按钮");
        button_click.setKey("btn_click");
        buttons.add(button_click);

        WxMenuButton button_view = new WxMenuButton();
        button_view.setType("view");
        button_view.setName("打开代码坞");
        button_view.setUrl("http://www.codewood.top");
        buttons.add(button_view);

        WxMenuButton button_menu = new WxMenuButton();
        button_menu.setName("菜单");

        WxMenuButton sub_button_click = new WxMenuButton();
        sub_button_click.setType("click");
        sub_button_click.setName("也是点击");
        sub_button_click.setKey("also_click");
        button_menu.getSubButtons().add(sub_button_click);

        WxMenuButton sub_button_view = new WxMenuButton();
        sub_button_view.setType("view");
        sub_button_view.setName("百度");
        sub_button_view.setUrl("http://www.baidu.com");
        button_menu.getSubButtons().add(sub_button_view);

        buttons.add(button_menu);
        wxMenu.setButtons(buttons);

        System.out.println(wxMenu.toJson());

        String respStr = wxMpService.createMenu(accessToken, wxMenu);
        System.out.println("respStr: " + respStr);

    }

    //@Test
    public void queryWxMenu() {
        String respStr = WxMpApi.queryMenu(accessToken);
        Gson gson = WxGsonBuilder.create();
        JsonObject json = gson.fromJson(respStr, JsonObject.class);
        if (json.get("is_menu_open").getAsInt() == 0) {
            // 微信公众号菜单未启用
        } else {
            WxMenu wxMenu = WxGsonBuilder.create().fromJson(json.get("selfmenu_info"), WxMenu.class);
            System.out.println("wxMenu: " + wxMenu);
        }
    }


}
