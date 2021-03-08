package top.codewood.wx.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.codewood.wx.mp.property.WxMpProperty;
import top.codewood.wx.mp.property.WxPayProperty;

@Configuration
@EnableConfigurationProperties({WxMpProperty.class, WxPayProperty.class})
public class WxConfig {

}