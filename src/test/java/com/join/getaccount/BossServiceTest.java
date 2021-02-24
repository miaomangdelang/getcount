package com.join.getaccount;

import com.join.getaccount.service.BossService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: join路yao
 * @Date: 2018/11/25 19:48
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BossServiceTest {

    @Resource
    BossService bossService;

//    @Test
//    public void getBossJavaInfoTest(){
////        String catchUrl = "https://www.baidu.com/";
//        String catchUrl = "";
//        bossService.getBossJavaInfo(catchUrl);
//    }


}
