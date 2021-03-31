package top.codewood.wx.mnp.bean.ocr;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 文本识别
 */
public class PrintedTextOcrResult implements Serializable {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PrintedTextOcrResult{" +
                "items=" + items +
                '}';
    }

    public static class Item implements Serializable {
        private String text;
        @SerializedName("pos")
        private Position position;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "text='" + text + '\'' +
                    ", position=" + position +
                    '}';
        }
    }

    public static class Position implements Serializable {
        @SerializedName("left_top")
        private Location leftTop;
        @SerializedName("right_top")
        private Location rightTop;
        @SerializedName("right_bottom")
        private Location rightBottom;
        @SerializedName("left_bottom")
        private Location leftBottom;

        public Location getLeftTop() {
            return leftTop;
        }

        public void setLeftTop(Location leftTop) {
            this.leftTop = leftTop;
        }

        public Location getRightTop() {
            return rightTop;
        }

        public void setRightTop(Location rightTop) {
            this.rightTop = rightTop;
        }

        public Location getRightBottom() {
            return rightBottom;
        }

        public void setRightBottom(Location rightBottom) {
            this.rightBottom = rightBottom;
        }

        public Location getLeftBottom() {
            return leftBottom;
        }

        public void setLeftBottom(Location leftBottom) {
            this.leftBottom = leftBottom;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "leftTop=" + leftTop +
                    ", rightTop=" + rightTop +
                    ", rightBottom=" + rightBottom +
                    ", leftBottom=" + leftBottom +
                    '}';
        }
    }

    public static class Location implements Serializable {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
