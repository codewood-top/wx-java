package top.codewood.wx.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.codewood.wx.config.property.WxMpProperty;
import top.codewood.wx.config.property.WxPayProperties;

@Configuration
@EnableConfigurationProperties({WxMpProperty.class, WxPayProperties.class})
public class WxConfig {

}