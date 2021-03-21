package top.codewood.wx.pay.v2.common;

public class WxPayConstants {

    public interface HttpMethod {
        String POST = "POST";
        String GET = "GET";
        String PUT = "PUT";
    }


    public enum PayType {
        /**
         * JSAPI/小程序下单
         */
        JSAPI,
        APP,
        NATIVE,
        H5;

    }


    public interface V2PayUrl {

        /**
         * 统一下单
         */
        String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

        /**
         * 查询订单
         */
        String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";

        /**
         * 关闭订单
         */
        String ORDER_CLOSE_URL = "https://api.mch.weixin.qq.com/pay/closeorder";

        /**
         * 申请退款
         */
        String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";

        /**
         * 查询退款
         */
        String REFUND_QUERY_URL = "https://api.mch.weixin.qq.com/pay/refundquery";

        /**
         * 下载交易账单
         */
        String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";

        /**
         * 下载资金账单
         */
        String DOWNLOAD_FUND_FLOW = "https://api.mch.weixin.qq.com/pay/downloadfundflow";

    }

    public interface EntPayUrl {
        /**
         * 发放红包接口
         * 需要证书
         */
        String REDPACK_SEND_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

        /**
         * 发放裂变红包
         * 需要证书
         */
        String REDPACK_GROUP_SEND_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";

        /**
         * 查询红包记录
         * 需要证书
         */
        String REDPACK_QUERY_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

        /**
         * 企业付款
         * 需要证书
         */
        String ENTPAY_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

        /**
         * 查询企业付款
         * 需要证书
         */
        String ENTPAY_QUERY_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

        /**
         * 企业付款到银行卡
         * 需要证书
         */
        String ENTPAY_PAY_BANK_URL = "https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank";

        /**
         * 查询企业付款银行卡
         * 需要证书
         */
        String ENTPAY_PAY_BANK_QUERY_URL = "https://api.mch.weixin.qq.com/mmpaysptrans/query_bank";

        /**
         * 获取RSA加密公钥
         * 需要证书
         */
        String ENTPAY_RSA_PUBLIC_KEY_URL = "https://fraud.mch.weixin.qq.com/risk/getpublickey";
    }

    public interface ProfitSharingUrl {

        /**
         * 请求单次分账
         */
        String PROFIT_SHARING_URL = "https://api.mch.weixin.qq.com/secapi/pay/profitsharing";

        /**
         * 请求多次分账
         */
        String PROFIT_SHARING_MULTI_URL = "https://api.mch.weixin.qq.com/secapi/pay/multiprofitsharing";

        /**
         * 查询分账结果
         */
        String PROFIT_SHARING_QUERY_URL = "https://api.mch.weixin.qq.com/pay/profitsharingquery";

        /**
         * 添加分账接收方
         */
        String PROFIT_SHARING_ADD_RECEIVER_URL = "https://api.mch.weixin.qq.com/pay/profitsharingaddreceiver";

        /**
         * 删除分账接收方
         */
        String PROFIT_SHARING_REMOVE_RECEIVER_URL = "https://api.mch.weixin.qq.com/pay/profitsharingremovereceiver";

        /**
         * 完结分账
         */
        String PROFIT_SHARING_FINISH_URL = "https://api.mch.weixin.qq.com/secapi/pay/profitsharingfinish";

        /**
         * 查询订单待分账金额
         */
        String PROFIT_SHARING_ORDER_AMOUNT_QUERY_URL = "https://api.mch.weixin.qq.com/pay/profitsharingorderamountquery";

        /**
         * 分账回退
         */
        String PROFIT_SHARING_RETURN_URL = "https://api.mch.weixin.qq.com/secapi/pay/profitsharingreturn";

        /**
         * 回退结果查询
         */
        String PROFIT_SHARING_RETURN_QUERY_URL = "https://api.mch.weixin.qq.com/pay/profitsharingreturnquery";

    }

    public interface SignType {

        String HMAC_SHA256 = "HMAC-SHA256";
        String MD5 = "MD5";

    }

    public enum ProfitSharingReceiverType {
        /**
         * 商户号（mch_id或者sub_mch_id）
         */
        MERCHANT_ID,
        /**
         * 个人openid
         */
        PERSONAL_OPENID;
    }

    public enum ProfitShargingReceiverRelationType {

        /**
         * 服务商
         */
        SERVICE_PROVIDER,

        /**
         * 门店
         */
        STORE,

        /**
         * STORE_OWNER
         */
        STAFF,

        /**
         * 店主
         */
        STORE_OWNER,

        /**
         * 合作伙伴
         */
        PARTNER,

        /**
         * 总部
         */
        HEADQUARTER,

        /**
         * 品牌方
         */
        BRAND,

        /**
         * 分销商
         */
        DISTRIBUTOR,

        /**
         * 用户
         */
        USER,

        /**
         * 供应商
         */
        SUPPLIER,

        /**
         * 自定义
         */
        CUSTOM;
    }

    public enum Bank {
        BANK_1002(1002, "工商银行"),
        BANK_1005(1005, "农业银行"),
        BANK_1003(1003, "建设银行"),
        BANK_1026(1026, "中国银行"),
        BANK_1020(1020, "交通银行"),
        BANK_1001(1001, "招商银行"),
        BANK_1066(1066, "邮储银行"),
        BANK_1006(1006, "民生银行"),
        BANK_1010(1010, "平安银行"),
        BANK_1021(1021, "中信银行"),
        BANK_1004(1004, "浦发银行"),
        BANK_1009(1009, "兴业银行"),
        BANK_1022(1022, "光大银行"),
        BANK_1027(1027, "广发银行"),
        BANK_1025(1025, "华夏银行"),
        BANK_1056(1056, "宁波银行"),
        BANK_4836(4836, "北京银行"),
        BANK_1024(1024, "上海银行"),
        BANK_1054(1054, "南京银行"),
        BANK_4755(4755, "长子县融汇村镇银行"),
        BANK_4216(4216, "长沙银行"),
        BANK_4051(4051, "浙江泰隆商业银行"),
        BANK_4753(4753, "中原银行"),
        BANK_4761(4761, "企业银行（中国）"),
        BANK_4036(4036, "顺德农商银行"),
        BANK_4752(4752, "衡水银行"),
        BANK_4756(4756, "长治银行"),
        BANK_4767(4767, "大同银行"),
        BANK_4115(4115, "河南省农村信用社"),
        BANK_4150(4150, "宁夏黄河农村商业银行"),
        BANK_4156(4156, "山西省农村信用社"),
        BANK_4166(4166, "安徽省农村信用社"),
        BANK_4157(4157, "甘肃省农村信用社"),
        BANK_4153(4153, "天津农村商业银行"),
        BANK_4113(4113, "广西壮族自治区农村信用社"),
        BANK_4108(4108, "陕西省农村信用社"),
        BANK_4076(4076, "深圳农村商业银行"),
        BANK_4052(4052, "宁波鄞州农村商业银行"),
        BANK_4764(4764, "浙江省农村信用社联合社"),
        BANK_4217(4217, "江苏省农村信用社联合社"),
        BANK_4072(4072, "江苏紫金农村商业银行股份有限公司"),
        BANK_4769(4769, "北京中关村银行股份有限公司"),
        BANK_4778(4778, "星展银行（中国）有限公司"),
        BANK_4766(4766, "枣庄银行股份有限公司"),
        BANK_4758(4758, "海口联合农村商业银行股份有限公司"),
        BANK_4763(4763, "南洋商业银行（中国）有限公司");

        int id;
        String name;

        Bank(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Bank getBank(int id) {
            for (Bank bank : Bank.values()) {
                if (bank.id == id) return bank;
            }
            return null;
        }
    }

}
