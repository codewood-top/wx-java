package top.codewood.wx.mp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import top.codewood.wx.mp.util.json.WxGsonBuilder;
import top.codewood.wx.mp.api.WxMpMenuApi;
import top.codewood.wx.mp.bean.menu.WxMenu;
import top.codewood.wx.mp.bean.menu.WxMenuButton;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WxJavaSpringBootApplication.class)
public class WxMenuTest {

    static String accessToken = "";
    
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

        String respStr = WxMpMenuApi.create(accessToken, wxMenu);
        System.out.println("respStr: " + respStr);

    }

    //@Test
    public void queryWxMenu() {
        WxMenu wxMenu = WxMpMenuApi.query(accessToken);
        System.out.println("wxMenu: " + wxMenu);

    }


}
