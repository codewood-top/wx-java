package top.codewood.wx.mnp.bean.express;

import java.util.HashMap;
import java.util.Map;

public class WxMnpExpressConstant {

    private final static Map<Integer, String>  PATH_ACTION_TYPE_MAP = new HashMap<>();

    static {
        PATH_ACTION_TYPE_MAP.put(100001, "揽件阶段 - 揽件成功");
        PATH_ACTION_TYPE_MAP.put(100002, "揽件阶段 - 揽件失败");
        PATH_ACTION_TYPE_MAP.put(100003, "揽件阶段 - 分配业务员");
        PATH_ACTION_TYPE_MAP.put(200001, "运输阶段 - 更新运输轨迹");
        PATH_ACTION_TYPE_MAP.put(300002, "派送阶段 - 开始派送");
        PATH_ACTION_TYPE_MAP.put(300003, "派送阶段 - 签收成功");
        PATH_ACTION_TYPE_MAP.put(300004, "派送阶段 - 签收失败");
        PATH_ACTION_TYPE_MAP.put(400001, "异常阶段 - 订单取消");
        PATH_ACTION_TYPE_MAP.put(400002, "异常阶段 - 订单滞留");
    }

    public static String getPathActionType(Integer actionType) {
        return PATH_ACTION_TYPE_MAP.get(actionType);
    }


}
