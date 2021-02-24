package com.join.getaccount.service.impl;

import com.join.getaccount.service.BossService;
import com.join.getaccount.util.HttpUtil;
import com.join.getaccount.util.JsonSourceUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * boss直聘 爬取
 *
 * @ClassName BossServiceImpl
 * @Description
 * @Author join路yao
 * @Date 2018/11/25 15:47
 */
@Service
public class BossServiceImpl implements BossService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    JsonSourceUtil jsonSourceUtil;
    @Override
    public void getBossJavaInfo(String catchUrl) {
        try {
            String data = HttpUtil.sendGet(catchUrl,null,jsonSourceUtil.getMap());
            Document doc= Jsoup.parse(data);
            Elements aClass = doc.getElementsByAttributeValue("class", "job-list").select("li .job-primary");
            aClass.forEach(ele->{
                Elements primary = ele.select(".info-primary");
//                primary.select();
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
