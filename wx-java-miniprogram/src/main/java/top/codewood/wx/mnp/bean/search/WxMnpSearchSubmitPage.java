package top.codewood.wx.mnp.bean.search;

import java.io.Serializable;

public class WxMnpSearchSubmitPage implements Serializable {

    /**
     * 页面路径
     */
    private String path;
    /**
     * 页面参数
     */
    private String query;

    public WxMnpSearchSubmitPage() {}

    public WxMnpSearchSubmitPage(String path, String query) {
        this.path = path;
        this.query = query;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "WxMnpSearchSubmitPage{" +
                "path='" + path + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
