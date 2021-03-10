package top.codewood.wx.pay.v2.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

public class WxPayBaseResult implements Serializable {

    /**
     * 返回状态码
     * SUCCESS/FAIL
     * 此字段是通信标识，非红包发放结果标识，红包发放是否成功需要查看result_code来判断
     */
    @XStreamAlias("return_code")
    protected String returnCode;

    /**
     * 返回信息
     * 返回信息，如非空，为错误原因
     * 签名失败
     * 参数格式校验错误
     */
    @XStreamAlias("return_msg")
    protected String returnMsg;

    /**
     * 业务结果
     * SUCCESS/FAIL
     * 注意：当状态为FAIL时，存在业务结果未明确的情况。所以如果状态是FAIL，请务必再请求一次查询接口[请务必关注错误代码（err_code字段），通过查询得到的红包状态确认此次发放的结果。]，以确认此次发放的结果。
     */
    @XStreamAlias("result_code")
    protected String resultCode;

    /**
     * 错误代码
     * 注意：出现未明确的错误码（SYSTEMERROR等）时，请务必用原商户订单号重试，或者再请求一次查询接口以确认此次发放的结果。
     */
    @XStreamAlias("err_code")
    protected String errCode;

    /**
     * 错误代码描述
     */
    @XStreamAlias("err_code_des")
    protected String errCodeDes;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }
}
