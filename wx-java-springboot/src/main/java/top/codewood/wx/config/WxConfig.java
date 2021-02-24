package top.codewood.wx.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.codewood.wx.mp.property.WxMpProperty;

@Configuration
@EnableConfigurationProperties({WxMpProperty.class})
public class WxConfig {
}
