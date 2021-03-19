package top.codewood.wx.pay.v2.util.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

public class AesUtil {

    public static String decryptToString(String encryptedStr, String key) {

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedStr);
            String keyMd5 = DigestUtils.md5Hex(key);
            Security.addProvider(new BouncyCastleProvider());
            SecretKey secretKey = new SecretKeySpec(keyMd5.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(decodedBytes), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
