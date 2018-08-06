package com.zoctan.api.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by zxw on 2018/8/6 0006.
 * 导入XML文件
 */
@Configuration
@ImportResource(locations = {"classpath:application-memcache.xml"})
public class XMLImportConfig {
}
