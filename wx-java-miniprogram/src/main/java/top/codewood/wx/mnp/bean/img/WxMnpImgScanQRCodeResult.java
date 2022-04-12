package top.codewood.wx.mnp.bean.img;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WxMnpImgScanQRCodeResult implements Serializable {

    @SerializedName("code_results")
    private CodeResult[] codeResults;
    @SerializedName("img_size")
    private ImgSize imgSize;

    public CodeResult[] getCodeResults() {
        return codeResults;
    }

    public void setCodeResults(CodeResult[] codeResults) {
        this.codeResults = codeResults;
    }

    public ImgSize getImgSize() {
        return imgSize;
    }

    public void setImgSize(ImgSize imgSize) {
        this.imgSize = imgSize;
    }

    public static class CodeResult implements Serializable {
        @SerializedName("type_name")
        private String typeName;
        private String data;
        private Position pos;
    }

    public static class Position implements Serializable {
        @SerializedName("left_top")
        private Coordinate leftTop;
        @SerializedName("right_top")
        private Coordinate rightTop;
        @SerializedName("right_bottom")
        private Coordinate rightBottom;
        @SerializedName("left_bottom")
        private Coordinate leftBottom;

        public Coordinate getLeftTop() {
            return leftTop;
        }

        public void setLeftTop(Coordinate leftTop) {
            this.leftTop = leftTop;
        }

        public Coordinate getRightTop() {
            return rightTop;
        }

        public void setRightTop(Coordinate rightTop) {
            this.rightTop = rightTop;
        }

        public Coordinate getRightBottom() {
            return rightBottom;
        }

        public void setRightBottom(Coordinate rightBottom) {
            this.rightBottom = rightBottom;
        }

        public Coordinate getLeftBottom() {
            return leftBottom;
        }

        public void setLeftBottom(Coordinate leftBottom) {
            this.leftBottom = leftBottom;
        }
    }

    public static class Coordinate implements Serializable {
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
    }

}
