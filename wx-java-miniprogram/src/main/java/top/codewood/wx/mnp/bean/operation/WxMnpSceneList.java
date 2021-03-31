package top.codewood.wx.mnp.bean.operation;

import java.io.Serializable;
import java.util.List;

public class WxMnpSceneList implements Serializable {

    private List<Scene> scene;

    public List<Scene> getScene() {
        return scene;
    }

    public void setScene(List<Scene> scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "WxMnpSceneList{" +
                "scene=" + scene +
                '}';
    }

    public static class Scene implements Serializable {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Scene{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
