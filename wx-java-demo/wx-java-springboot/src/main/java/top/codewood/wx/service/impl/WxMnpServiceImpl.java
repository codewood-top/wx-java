package top.codewood.wx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.codewood.wx.common.api.WxConstants;
import top.codewood.wx.config.property.WxAppProperties;
import top.codewood.wx.config.property.WxAppProperty;
import top.codewood.wx.mnp.api.WxMnpApi;
import top.codewood.wx.mnp.bean.result.WxMnpCode2SessionResult;
import top.codewood.wx.service.WxMnpService;

@Service("wxMnpService")
public class WxMnpServiceImpl implements WxMnpService {

    static final Logger LOGGER = LoggerFactory.getLogger(WxMnpServiceImpl.class);

    @Autowired
    private WxAppProperties wxAppProperties;

    @Override
    public WxMnpCode2SessionResult code2Session(String code) {
        WxAppProperty wxAppProperty = wxAppProperties.getAppPropertyByType(WxConstants.AppType.MINIPROGRAM);
        return WxMnpApi.getInstance().code2Session(wxAppProperty.getAppid(), wxAppProperty.getSecret(), code);
    }
}
