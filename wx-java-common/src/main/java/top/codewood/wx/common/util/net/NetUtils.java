package top.codewood.wx.common.util.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetUtils {

    /**
     * 读取本机IP地址
     * @return
     */
    public static String localAddress() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        } catch (UnknownHostException e) {
           throw new RuntimeException(e.getMessage());
        }
    }

}
