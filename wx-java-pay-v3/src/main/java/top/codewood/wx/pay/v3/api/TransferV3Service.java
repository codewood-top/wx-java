package top.codewood.wx.pay.v3.api;

import com.google.gson.JsonObject;
import top.codewood.wx.pay.v3.bean.transfer.*;
import top.codewood.wx.pay.v3.common.WxPayConfig;
import top.codewood.wx.pay.v3.util.json.WxGsonBuilder;

public class TransferV3Service {

    private WxPayConfig wxPayConfig;

    public TransferV3Service(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    /**
     * 发起商家转账
     * 发起商家转账接口。商户可以通过该接口同时向多个用户微信零钱进行转账操作。请求消息中应包含商家批次单号、转账名称、appid、转账总金额、转账总笔数、转账openid、收款用户姓名等信息。
     *
     * <a href=“https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-batch/initiate-batch-transfer.html”>开发文档</a>
     */
    public BatchV3Result batches(BatchV3Request request) {
        assert wxPayConfig != null && request != null;
        String url = "https://api.mch.weixin.qq.com/v3/transfer/batches";
        String respStr = WxPayV3Api.post(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, WxGsonBuilder.instance().toJson(request));
        return WxGsonBuilder.instance().fromJson(respStr, BatchV3Result.class);
    }

    /**
     * 通过微信批次单号查询批次单
     * 微信批次单号查单接口。商户可以通过该接口查询转账批次单以及指定状态的转账明细单。返回消息中包含微信批次单号、批次状态、批次类型、转账总金额、转账总笔数、成功金额、失败金额等信息。
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-batch/get-transfer-batch-by-no.html">开发文档</a>
     *
     * @param batchId 【微信批次单号】 微信批次单号，微信商家转账系统返回的唯一标识
     * @return
     */
    public GetBatchV3Result getWithBatchId(String batchId) {
        assert wxPayConfig != null && batchId != null;
        String url = "https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/" + batchId;
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, GetBatchV3Result.class);
    }

    /**
     * 通过商家批次单号查询批次单
     * 商家明细单号查单接口。商户可以通过该接口查询转账批次单以及指定状态的转账明细单。返回消息中包含微信批次单号、批次状态、批次类型、转账总金额、转账总笔数、成功金额、失败金额等信息。
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-batch/get-transfer-batch-by-out-no.html">开发文档</a>
     *
     * @param outBatchNo 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一
     * @return
     */
    public GetBatchV3Result getWithOutNo(String outBatchNo) {
        assert wxPayConfig != null && outBatchNo != null;
        String url = "https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/" + outBatchNo;
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, GetBatchV3Result.class);
    }

    /**
     * 通过微信明细单号查询明细单
     * 明细单号查单接口。商户可以通过该接口查询单笔转账明细单。返回消息中包含微信明细单号、明细状态、转账金额、失败原因、收款用户姓名、用户OpenID等信息。
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-detail/get-transfer-detail-by-no.html">开发文档</a>
     *
     * @param batchId 【微信批次单号】 微信批次单号，微信商家转账系统返回的唯一标识
     * @param detailId 【微信明细单号】 微信支付系统内部区分转账批次单下不同转账明细单的唯一标识
     * @return
     */
    public GetBatchDetailV3Result getDetailWithId(String batchId, String detailId) {
        assert wxPayConfig != null && batchId != null && detailId != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/%s/details/detail-id/%s", batchId, detailId);
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, GetBatchDetailV3Result.class);
    }

    /**
     * 通过商家明细单号查询明细单
     * 商户明细单号查单接口。商户可以通过该接口查询单笔转账明细单。返回消息中包含微信明细单号、明细状态、转账金额、失败原因、收款用户姓名、用户OpenID等信息。
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-detail/get-transfer-detail-by-out-no.html">开发文档</a>
     *
     * @param outBatchNo 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一
     * @param outDetailNo 【商家明细单号】 商户系统内部区分转账批次单下不同转账明细单的唯一标识
     * @return
     */
    public GetBatchDetailV3Result getDetailWithOutNo(String outBatchNo, String outDetailNo) {
        assert wxPayConfig != null && outBatchNo != null && outDetailNo != null;
        String url = String.format("https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/%s/details/out-detail-no/%s", outBatchNo, outDetailNo);
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, GetBatchDetailV3Result.class);
    }

    /**
     * 转账账单电子回单申请受理接口
     * 转账账单电子回单申请受理接口，商户通过该接口可以申请受理电子回单服务。 前置条件：1、发起转账时传入了收款用户姓名，支持申请电子回单；2、支持受理最近两年内的转账批次单；
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/electronic-signature/create-electronic-signature.html">开发文档</a>
     *
     * @param outBatchNo 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一。需要电子回单的批次单号
     * @return
     */
    public BillReceiptV3Result billReceipt(String outBatchNo) {
        assert wxPayConfig != null && outBatchNo != null;
        String url = "https://api.mch.weixin.qq.com/v3/transfer/bill-receipt";
        String respStr = WxPayV3Api.post(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, outBatchNo);
        return WxGsonBuilder.instance().fromJson(respStr, BillReceiptV3Result.class);
    }

    /**
     * 查询转账账单电子回单接口
     * 查询转账账单电子回单接口，商户通过该接口可以查询电子回单受理进度信息，包括电子回单据信息，电子回单文件的hash值，电子回单文件的下载地址等
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/electronic-signature/get-electronic-signature-by-out-no.html">开发文档</a>
     *
     * @param outBatchNo 【商家批次单号】 商户系统内部的商家批次单号，在商户系统内部唯一。需要电子回单的批次单号
     * @return
     */
    public BillReceiptV3Result queryBillReceipt(String outBatchNo) {
        assert wxPayConfig != null && outBatchNo != null;

        String url = "https://api.mch.weixin.qq.com/v3/transfer/bill-receipt/" + outBatchNo;
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, BillReceiptV3Result.class);
    }

    /**
     * 受理转账明细电子回单API
     * 受理转账明细电子回单接口，商户通过该接口可以申请受理转账明细单电子回单服务。 前置条件：1、发起转账时传入了收款用户姓名，支持申请电子回单；2、只支持受理最近两年内的转账明细单 URL路径：https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts
     *
     * <a href="https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/electronic-receipt-api/create-electronic-receipt.html">开发文档</a>
     *
     * @param acceptType 必填 【受理类型】 电子回单受理类型：BATCH_TRANSFER：批量转账明细电子回单 TRANSFER_TO_POCKET：企业付款至零钱电子回单 TRANSFER_TO_BANK：企业付款至银行卡电子回单
     * 可选取值：
     * BATCH_TRANSFER: 批量转账明细电子回单
     * TRANSFER_TO_POCKET: 企业付款至零钱电子回单
     * TRANSFER_TO_BANK: 企业付款至银行卡电子回单
     * @param outBatchNo 选填  【商家转账批次单号】 需要电子回单的批量转账明细单所在的转账批次的单号，该单号为商户申请转账时生成的商户单号。受理类型为BATCH_TRANSFER时该单号必填，否则该单号留空。
     * @param outDetailNo 必填 【商家转账明细单号】 该单号为商户申请转账时生成的商家转账明细单号。 1.受理类型为BATCH_TRANSFER时填写商家批量转账明细单号。2. 受理类型为TRANSFER_TO_POCKET或TRANSFER_TO_BANK时填写商家转账单号。
     * @return
     */
    public DetailElectronicReceiptV3Result detailElectronicReceipts(String acceptType, String outBatchNo, String outDetailNo) {
        assert wxPayConfig != null && acceptType != null && outDetailNo != null;

        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("access_type", acceptType);
        paramJson.addProperty("out_detail_no", outDetailNo);

        if (outBatchNo != null) {
            paramJson.addProperty("out_batch_no", outBatchNo);
        }

        String url = "https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts";
        String respStr = WxPayV3Api.post(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url, paramJson.toString());
        return WxGsonBuilder.instance().fromJson(respStr, DetailElectronicReceiptV3Result.class);
    }

    /**
     * 查询转账明细电子回单受理结果API
     * 查询转账明细电子回单受理结果接口，商户通过该接口可以查询电子回单受理进度信息，包括电子回单据信息，电子回单文件的hash值，电子回单文件的下载地址等。 前置条件：只支持查询最近两年内的转账明细单 URL路径：https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts
     *
     * @param acceptType 必填 【受理类型】 电子回单受理类型：BATCH_TRANSFER：批量转账明细电子回单 TRANSFER_TO_POCKET：企业付款至零钱电子回单 TRANSFER_TO_BANK：企业付款至银行卡电子回单
     * 可选取值：
     * BATCH_TRANSFER: 批量转账明细电子回单
     * TRANSFER_TO_POCKET: 企业付款至零钱电子回单
     * TRANSFER_TO_BANK: 企业付款至银行卡电子回单
     * @param outBatchNo 选填  【商家转账批次单号】 需要电子回单的批量转账明细单所在的转账批次的单号，该单号为商户申请转账时生成的商户单号。受理类型为BATCH_TRANSFER时该单号必填，否则该单号留空。
     * @param outDetailNo 必填 【商家转账明细单号】 该单号为商户申请转账时生成的商家转账明细单号。 1.受理类型为BATCH_TRANSFER时填写商家批量转账明细单号。2. 受理类型为TRANSFER_TO_POCKET或TRANSFER_TO_BANK时填写商家转账单号。
     * @return
     */
    public DetailElectronicReceiptV3Result getDetailElectronicReceipts(String acceptType, String outBatchNo, String outDetailNo) {
        assert wxPayConfig != null && acceptType != null && outDetailNo != null;

        String url = String.format("https://api.mch.weixin.qq.com/v3/transfer-detail/electronic-receipts?accept_type=%s&out_detail_no=%s", acceptType, outDetailNo);
        if (outBatchNo != null) {
            url += "&out_batch_no=" + outBatchNo;
        }
        String respStr = WxPayV3Api.get(wxPayConfig.getMchid(), wxPayConfig.getSerialNo(), url);
        return WxGsonBuilder.instance().fromJson(respStr, DetailElectronicReceiptV3Result.class);
    }


}
