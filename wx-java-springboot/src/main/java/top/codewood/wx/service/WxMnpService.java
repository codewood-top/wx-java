package top.codewood.wx.service;

import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;

public interface WxMnpService {

    WxMnpCode2SessionResult code2Session(String appid, String jscode);
}
