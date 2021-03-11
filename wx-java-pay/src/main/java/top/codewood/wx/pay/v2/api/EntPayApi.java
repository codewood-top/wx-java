package top.codewood.wx.pay.v2.api;

import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.common.bean.error.WxErrorException;
import top.codewood.wx.common.util.bean.BeanUtils;
import top.codewood.wx.common.util.xml.XStreamConverter;
import top.codewood.wx.pay.common.WxPayConstants;
import top.codewood.wx.pay.v2.bean.WxPayBaseResult;
import top.codewood.wx.pay.v2.bean.entpay.*;
import top.codewood.wx.pay.v2.bean.redpack.*;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

public class EntPayApi extends WxPayV2Api {


    private static class Holder {
        private static EntPayApi INSTANCE = new EntPayApi();
    }

    public static EntPayApi getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 发放红包接口
     * 1.发送频率限制------默认30/秒
     * 2.发送个数上限------默认30/秒
     * 3.场景金额限制------默认红包金额为1-200元，如有需要，可前往商户平台进行设置和申请
     * 4.其他限制------商户单日出资金额上限--100万元；单用户单日收款金额上限--1000元；单用户单日可领取红包个数上限--10个
     * @param redPackRequest
     * @param mchid
     * @param certFileInputStream
     * @return
     */
    public WxPayRedPackResult sendRedPack(WxPayRedPackRequest redPackRequest, String mchid, InputStream certFileInputStream) {
        assert redPackRequest != null;

        redPackRequest.checkRequiredFields();
        String xml = XStreamConverter.toXml(redPackRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.REDPACK_SEND_URL, xml, mchid, certFileInputStream);

        WxPayRedPackResult wxPayRedPackResult = XStreamConverter.fromXml(WxPayRedPackResult.class, respStr);
        checkResult(wxPayRedPackResult);
        return wxPayRedPackResult;
    }

    /**
     * 发放裂变红包
     * 裂变红包：一次可以发放一组红包。首先领取的用户为种子用户，种子用户领取一组红包当中的一个，并可以通过社交分享将剩下的红包给其他用户。裂变红包充分利用了人际传播的优势。
     *
     * @param redPackRequest
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public WxPayRedPackResult sendGroupRedPack(WxPayGroupRedPackRequest redPackRequest, String password, InputStream certFileInputStream) {
        assert redPackRequest != null;

        redPackRequest.checkRequiredFields();
        String xml = XStreamConverter.toXml(redPackRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.REDPACK_SEND_URL, xml, password, certFileInputStream);

        WxPayRedPackResult redPackResult = XStreamConverter.fromXml(WxPayRedPackResult.class, respStr);
        checkResult(redPackResult);
        return redPackResult;
    }

    /**
     * 查询红包记录
     * 用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包。
     *
     * 注意事项
     * ◆ 查询红包记录API只支持查询30天内的红包订单，30天之前的红包订单请登录商户平台查询。
     * ◆ 如果查询单号对应的数据不存在，那么数据不存在的原因可能是：（1）发放请求还在处理中；（2）红包发放处理失败导致红包订单没有落地。在上述情况下，商户首先需要检查该商户订单号是否确实是自己发起的，如果商户确认是自己发起的，则请商户不要直接当做红包发放失败处理，请商户隔几分钟再尝试查询，或者商户可以通过相同的商户订单号再次发起发放请求。如果商户误把还在发放中的订单直接当发放失败处理，商户应当自行承担因此产生的所有损失和责任。
     * ◆ XML具有可扩展性，因此返回参数可能会有新增，而且顺序可能不完全遵循此文档规范，如果在解析回包的时候发生错误，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新回包字段，会更新到此API文档中。
     * ◆ 因为错误代码字段err_code的值后续可能会增加，所以商户如果遇到回包返回新的错误码，请商户务必不要换单重试，请商户联系客服确认红包发放情况。如果有新的错误码，会更新到此API文档中。
     * ◆ 错误代码描述字段err_code_des只供人工定位问题时做参考，系统实现时请不要依赖这个字段来做自动化处理。
     *
     * @param redPackQueryRequest
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public WxPayRedPackQueryResult queryRedPack(WxPayRedPackQueryRequest redPackQueryRequest, String password, InputStream certFileInputStream) {
        assert redPackQueryRequest != null;

        redPackQueryRequest.checkRequiredFields();
        String xml = XStreamConverter.toXml(redPackQueryRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.REDPACK_QUERY_URL, xml, password, certFileInputStream);

        WxPayRedPackQueryResult redPackQueryResult = XStreamConverter.fromXml(WxPayRedPackQueryResult.class, respStr);
        checkResult(redPackQueryResult);
        return redPackQueryResult;
    }

    /**
     * 企业付款
     * 用于企业向微信用户个人付款
     * 目前支持向指定微信用户的openid付款。
     *
     * @param entPayRequest
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public EntPayResult entPay(EntPayRequest entPayRequest, String password, InputStream certFileInputStream) {
        assert entPayRequest != null;

        BeanUtils.checkRequiredFields(entPayRequest);
        String xml = XStreamConverter.toXml(entPayRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.ENTPAY_URL, xml, password, certFileInputStream);

        EntPayResult entPayResult = XStreamConverter.fromXml(EntPayResult.class, respStr);
        checkResult(entPayResult);
        return entPayResult;
    }

    /**
     * 查询企业付款
     *
     * 用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
     * 查询企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询。
     *
     * @param entPayQueryRequest
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public EntPayQueryResult entPayQuery(EntPayQueryRequest entPayQueryRequest, String password, InputStream certFileInputStream) {
        assert entPayQueryRequest != null;
        entPayQueryRequest.checkRequiredFields();

        String xml = XStreamConverter.toXml(entPayQueryRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.ENTPAY_QUERY_URL, xml, password, certFileInputStream);

        EntPayQueryResult entPayQueryResult = XStreamConverter.fromXml(EntPayQueryResult.class, respStr);
        checkResult(entPayQueryResult);
        return entPayQueryResult;
    }

    /**
     * 企业付款到银行卡API
     * 企业付款业务是基于微信支付商户平台的资金管理能力，为了协助商户方便地实现企业向银行卡付款，针对部分有开发能力的商户，提供通过API完成企业付款到银行卡的功能。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_2">参考文档</a>
     *
     * @param entPayBankRequest
     * @param password  -> mchid
     * @param certFileInputStream
     * @return
     */
    public EntPayBankResult entPayBank(EntPayBankRequest entPayBankRequest, String signKey, String password, InputStream certFileInputStream) {
        assert entPayBankRequest != null;
        entPayBankRequest.checkRequiredFields();
        String publicKey = getPublicKey(entPayBankRequest.getMchid(), signKey, password, certFileInputStream);
        entPayBankRequest.setEncBankNo(this.encryptRSA(entPayBankRequest.getEncBankNo().replace(" ", ""), publicKey));
        entPayBankRequest.setEncTrueName(this.encryptRSA(entPayBankRequest.getEncTrueName(), publicKey));
        entPayBankRequest.setSign(sign(entPayBankRequest, signKey));

        String xml = XStreamConverter.toXml(entPayBankRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.ENTPAY_PAY_BANK_URL, xml, password, certFileInputStream);

        EntPayBankResult entPayBankResult = XStreamConverter.fromXml(EntPayBankResult.class, respStr);
        checkResult(entPayBankResult);
        return entPayBankResult;
    }

    /**
     * 查询企业付款银行卡
     * 用于对商户企业付款到银行卡操作进行结果查询，返回付款操作详细结果。
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_3">参考文档</a>
     * @param entPayQueryRequest
     * @param password
     * @param certFileInputStream
     * @return
     */
    public EntPayBankQueryResult entPayBankQuery(EntPayQueryRequest entPayQueryRequest, String password, InputStream certFileInputStream) {
        assert entPayQueryRequest != null;
        entPayQueryRequest.checkRequiredFields();
        String xml = XStreamConverter.toXml(entPayQueryRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.ENTPAY_PAY_BANK_QUERY_URL, xml, password, certFileInputStream);
        EntPayBankQueryResult entPayBankQueryResult = XStreamConverter.fromXml(EntPayBankQueryResult.class, respStr);
        checkResult(entPayBankQueryResult);
        return entPayBankQueryResult;
    }

    /**
     * 获取RSA加密公钥API
     *
     * RSA算法使用说明（非对称加密算法，算法采用RSA/ECB/OAEPPadding模式）
     * 1、 调用获取RSA公钥API获取RSA公钥，落地成本地文件，假设为public.pem
     * 2、 确定public.pem文件的存放路径，同时修改代码中文件的输入路径，加载RSA公钥
     * 3、 用标准的RSA加密库对敏感信息进行加密，选择RSA_PKCS1_OAEP_PADDING填充模式
     *       （eg：Java的填充方式要选 " RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING"）
     * 4、 得到进行rsa加密并转base64之后的密文
     * 5、 将密文传给微信侧相应字段，如付款接口（enc_bank_no/enc_true_name）
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7">参考文档</a>
     *
     * @param getPublicKeyRequest
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public String getPublicKey(GetPublicKeyRequest getPublicKeyRequest, String password, InputStream certFileInputStream) {
        assert getPublicKeyRequest != null;

        BeanUtils.checkRequiredFields(getPublicKeyRequest);
        String xml = XStreamConverter.toXml(getPublicKeyRequest);
        String respStr = sslPost(WxPayConstants.EntPayUrl.ENTPAY_RSA_PUBLIC_KEY_URL, xml, password, certFileInputStream);

        GetPublicKeyResult getPublicKeyResult = XStreamConverter.fromXml(GetPublicKeyResult.class, respStr);
        checkResult(getPublicKeyResult);
        return getPublicKeyResult.getPubKey();
    }

    /**
     * 获取RSA加密公钥API
     *
     * RSA算法使用说明（非对称加密算法，算法采用RSA/ECB/OAEPPadding模式）
     * 1、 调用获取RSA公钥API获取RSA公钥，落地成本地文件，假设为public.pem
     * 2、 确定public.pem文件的存放路径，同时修改代码中文件的输入路径，加载RSA公钥
     * 3、 用标准的RSA加密库对敏感信息进行加密，选择RSA_PKCS1_OAEP_PADDING填充模式
     *       （eg：Java的填充方式要选 " RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING"）
     * 4、 得到进行rsa加密并转base64之后的密文
     * 5、 将密文传给微信侧相应字段，如付款接口（enc_bank_no/enc_true_name）
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7">参考文档</a>
     *
     * @param mchid
     * @param signKey
     * @param password -> mchid
     * @param certFileInputStream
     * @return
     */
    public String getPublicKey(String mchid, String signKey, String password, InputStream certFileInputStream) {
        GetPublicKeyRequest getPublicKeyRequest = new GetPublicKeyRequest.Builder()
                .mchid(mchid)
                .nonceStr(UUID.randomUUID().toString().replace("-", ""))
                .build();

        getPublicKeyRequest.setSign(sign(getPublicKeyRequest, signKey));

        return getPublicKey(getPublicKeyRequest, password, certFileInputStream);
    }

    /**
     * RSA加密
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7&index=4">参考文档</a>
     *
     * @param message 需要加密的信息
     * @param publicKey
     * @return
     */
    private String encryptRSA(String message, String publicKey) {
        assert message != null && publicKey != null;
        try {
            byte[] decoded = Base64.getDecoder().decode(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("RSA加密失败, err: " + e.getMessage());
        }
    }

    private <T extends WxPayBaseResult> void  checkResult(T t) {
        if (!WxConstants.SUCCESS.equals(t.getReturnCode())) {
            throw new WxErrorException(t.getReturnMsg());
        }
        if (!WxConstants.SUCCESS.equals(t.getResultCode())) {
            throw new WxErrorException(t.getErrCodeDes());
        }
    }

}
