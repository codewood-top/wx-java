package top.codewood.wx.mnp.bean.live;

import java.io.Serializable;
import java.util.List;

public class WxMnpLiveGoodsListResult implements Serializable {

    /**
     * 商品数量
     */
    private Integer total;

    private List<WxMnpLiveGoodsInfo> goods;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<WxMnpLiveGoodsInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<WxMnpLiveGoodsInfo> goods) {
        this.goods = goods;
    }
}
