package top.codewood.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codewood.wx.config.property.WxAppProperty;
import top.codewood.wx.config.property.WxConfigProperties;
import top.codewood.wx.mnp.api.WxMnpApi;
import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;
import top.codewood.wx.service.WxMnpService;

@Service("wxMnpService")
public class WxMnpServiceImpl implements WxMnpService {

    @Autowired
    private WxConfigProperties wxConfigProperties;

    @Override
    public WxMnpCode2SessionResult code2Session(String appid, String jscode) {
        WxAppProperty wxAppProperty = wxConfigProperties.getAppProperty(appid);
        return WxMnpApi.getInstance().code2Session(wxAppProperty.getAppid(), wxAppProperty.getSecret(), jscode);
    }

}
