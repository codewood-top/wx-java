package top.codewood.wx.mnp.bean.img;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

public class WxMnpImgAiCropResult implements Serializable {

    private Result[] results;
    @SerializedName("img_size")
    private ImgSize imgSize;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public ImgSize getImgSize() {
        return imgSize;
    }

    public void setImgSize(ImgSize imgSize) {
        this.imgSize = imgSize;
    }

    @Override
    public String toString() {
        return "WxMnpImgAiCropResult{" +
                "results=" + Arrays.toString(results) +
                ", imgSize=" + imgSize +
                '}';
    }

    public static class Result implements Serializable {

        @SerializedName("crop_left")
        private int cropLeft;
        @SerializedName("crop_top")
        private int cropTop;
        @SerializedName("crop_right")
        private int cropRight;
        @SerializedName("crop_bottom")
        private int cropBottom;

        public int getCropLeft() {
            return cropLeft;
        }

        public void setCropLeft(int cropLeft) {
            this.cropLeft = cropLeft;
        }

        public int getCropTop() {
            return cropTop;
        }

        public void setCropTop(int cropTop) {
            this.cropTop = cropTop;
        }

        public int getCropRight() {
            return cropRight;
        }

        public void setCropRight(int cropRight) {
            this.cropRight = cropRight;
        }

        public int getCropBottom() {
            return cropBottom;
        }

        public void setCropBottom(int cropBottom) {
            this.cropBottom = cropBottom;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "cropLeft=" + cropLeft +
                    ", cropTop=" + cropTop +
                    ", cropRight=" + cropRight +
                    ", cropBottom=" + cropBottom +
                    '}';
        }
    }

}
