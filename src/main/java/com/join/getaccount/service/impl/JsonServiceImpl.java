package com.join.getaccount.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.join.getaccount.service.JsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: join路yao
 * @Date: 2018/12/8 19:20
 * @Description:
 */
@Service
public class JsonServiceImpl implements JsonService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Map<String, String> getMapByJsonString(String jsonStr) {
        try {
            return MAPPER.readValue(MAPPER.readTree(jsonStr).traverse(), Map.class);
        } catch (IOException e) {
            logger.error("解析json出错，请核对json格式");
            e.printStackTrace();
        }
        return null;
    }
}
