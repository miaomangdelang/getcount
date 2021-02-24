package com.join.getaccount.auto;

import com.join.getaccount.service.BossService;
import com.join.getaccount.service.GetAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时启动类
 * @ClassName TimerStaker
 * @Description
 * @Author Administrator
 * @Date 2018/10/16 14:37
 */
@Component
public class TimerStaker {
    private static Logger logger = LoggerFactory.getLogger(TimerStaker.class);
    @Value("${url.boss}")
    private String bossUrl;

    @Resource
    BossService bossService;
    @Resource
    GetAccountService getAccountService;
    /**
     * 定时启动接口
     */
//    @Scheduled(cron="0/5 * *  * * ? ")
//    @Scheduled(cron="0 1 0,6,12,18 * * ? ")
    public void getSSAccount(){
        logger.info("------------------started Web crawlers");
        getAccountService.getAccout();
        logger.info("------------------ended Web crawlers");
    }
//    @Scheduled(cron="0/5 * *  * * ? ")
    public void getBOSS(){
        logger.info("------------------started Web Boss--------------");
        bossService.getBossJavaInfo(bossUrl);
        logger.info("------------------started Web Boss--------------");
    }

}
