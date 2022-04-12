package top.codewood.wx.mnp.bean.img;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImgSize implements Serializable {

    @SerializedName("w")
    private int width;
    @SerializedName("h")
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "ImgSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
