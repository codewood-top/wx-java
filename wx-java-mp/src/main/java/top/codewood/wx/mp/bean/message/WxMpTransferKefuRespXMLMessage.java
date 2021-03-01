package top.codewood.wx.mp.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import top.codewood.wx.common.api.WxConstants;

@XStreamAlias("xml")
public class WxMpTransferKefuRespXMLMessage extends WxMpRespXmlMessage {

    {
        this.msgType = WxConstants.XmlMsgType.TRANSFER_CUSTOMER_SERVICE;
    }

    @XStreamAlias("TransInfo")
    private TransInfo transInfo;

    public TransInfo getTransInfo() {
        return transInfo;
    }

    public void setTransInfo(TransInfo transInfo) {
        this.transInfo = transInfo;
    }

    public static class TransInfo {

        @XStreamAlias("KfAccount")
        private String kfAccount;

        public TransInfo() {}

        public TransInfo(String kfAccount) {
            this.kfAccount = kfAccount;
        }

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }

}
