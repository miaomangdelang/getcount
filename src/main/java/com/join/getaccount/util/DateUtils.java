package com.join.getaccount.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description
 * @Author Administrator
 * @Date 2018/10/16 15:06
 */
public class DateUtils {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 设置时间格式
     * @param date 时间
     * @return 标准中文格式时间 String
     */
    public static String formatStandardChinaDate(Date date){
        return sdf.format(date);
    }

    /**
     * 设置时间格式
     * @param date 时间
     * @return 标准中文格式时间 String
     */
    public static String formatStandardChinaDate(long date){
        return formatStandardChinaDate(new Date(date));
    }

}
