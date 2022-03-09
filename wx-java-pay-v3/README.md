# wx-java-pay-v3使用说明

```java
String mchid = "", serialNo = "", v3Key = "";
InputStream is = this.getClass().getClassLoader().getResourceAsStream("apiclient_key.pem");
WxPayV3Api.loadPrivateKey(mchid, is);
List<CertificateItem> certificates = WxPayV3Api.certificates(mchid, serialNo);
WxPayV3Api.loadCertificates(v3Key, certificates);

WxPayConfig wxPayConfig = new WxPayConfig();
wxPayConfig.setMchid("");
wxPayConfig.setKey("");
wxPayConfig.setSerialNo("");
wxPayConfig.setKeyPath("apiclient_key.pem");
wxPayConfig.setNotifyUrl("notify_url");
wxPayConfig.setRefundNotifyUrl("refund_notify_url");

WxPayV3Service wxPayV3Service = new WxPayV3Service(wxPayConfig);
WxPayTransaction wxPayTransaction = wxPayV3Service.queryWithOutTradeNo("");

```