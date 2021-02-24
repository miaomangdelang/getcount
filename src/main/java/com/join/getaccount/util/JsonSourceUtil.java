package com.join.getaccount.util;

import com.join.getaccount.service.JsonService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: join路yao
 * @Date: 2018/12/14 20:00
 * @Description:
 */
@Component
public class JsonSourceUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    Map<String, String> map = new HashMap<>();
    @Value("classpath:config/header.json")
    private Resource header;
    @Autowired
    JsonService jsonService;
    C
    @PostConstruct
    private void init() {
        logger.info("开始初始化header Map");
        String json = null;
        try {
            json=IOUtils.toString(header.getInputStream(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            logger.info("load DataSourceMap.json fail. {}", e);
        } finally {
        }
        if (json != null) {
            map = jsonService.getMapByJsonString(json);
            logger.info("初始化Map 成功："+map.toString());
        }else
            logger.info("初始化Header 失败");
    }

    public Map<String, String> getMap() {
        return map;
    }
}
