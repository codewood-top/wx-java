package top.codewood.wx.common.util;

import java.util.Random;

public class StringUtils {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomString(int length) {
        assert length > 0;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM_STR.charAt(r.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }

}
