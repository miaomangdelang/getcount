package com.join.getaccount.test;

import com.join.getaccount.util.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.List;

/**
 * @ClassName Test
 * @Description
 * @Author Administrator
 * @Date 2018/10/16 15:47
 */
public class Test {
    public static String url ="https://us.ishadowx.net/";
    public static void main(String[] args) {
//        String data = HttpClientUtils.getetData(url);
//        Document doc= Jsoup.parse(data);
//        List<Element> elements = doc.getElementsByAttributeValue("class", "hover-text");
//        System.out.println(elements);
        String list = "2787655,2597829,2597860,2597858,2597857,2597854,2597859,2597903,2597900,2597904,2597905,2478887,2502403,2502404,2502405,2088887,2088886,2088883,1724361,1724351,1724356,1766062,1766065,1422298,1422315,1422327,1101672,1101671,1785768,1785769,1785767,1819545,1101670,1819523,1013904,3893693,3893692,3893679,3812272,3812284,3185619,3185625,3185618,3174280,3174277,3162498,3162503,3162729,3162735,3162719,3162718,2869797,2869796,2869950,2869800,2855987,2855984,2705888,2705886,2705885";


        String[] split = list.split(",");
        System.out.println(split.length);
        File file = new File("E:/下载");
        File[] files = file.listFiles();
        int count = 0;
        for (String id : split){
            boolean flag = false;
            for (File file1:files) {
                if (file1.getName().indexOf(id)>0){
                    System.out.println("name:"+file1.getName()+"====id:"+id);
                    flag=true;
                    break;
                }
            }
            if (!flag){
                System.out.println("fid:"+id);
                count++;
            }
        }
        System.out.println("count:"+count);
    }




}
