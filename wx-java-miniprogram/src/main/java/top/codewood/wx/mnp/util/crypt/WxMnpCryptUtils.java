package top.codewood.wx.mnp.util.crypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

public class WxMnpCryptUtils {

    /**
     *
     * @param sessionKey jscode2Session获得
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv 加密算法的初始向量
     * @return
     */
    public static String decrypt(String sessionKey, String encryptedData, String iv) {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] aesBytes = Base64.getDecoder().decode(sessionKey);
        byte[] ivBytes = Base64.getDecoder().decode(iv);

        try {
            SecretKey secretKey = new SecretKeySpec(aesBytes, "AES");
            IvParameterSpec ips = new IvParameterSpec(ivBytes);

            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ips);
            return new String(cipher.doFinal(encryptedBytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
