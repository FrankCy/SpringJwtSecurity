package com.cy.test.util;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.util
 * @email: cy880708@163.com
 * @date: 2018/9/3 下午6:15
 * @mofified By:
 */
public class BankVerify {

    public static void main(String[] args) {

        String cardNo="641333******4141";
        List<String> readLines = null;
        try {
            readLines = FileUtils.readLines(ResourceUtils.getFile("classpath:static/bankInfo.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(readLines.size());
        HashMap<String, String> map=new HashMap<String, String>();
        for (int i = 0; i < readLines.size(); i++) {
            String[] ss=readLines.get(i).split("=");
            map.put(ss[0], ss[1]);
        }
        cardNo=cardNo.replaceAll(" ", "");
        String temp=cardNo.substring(0,6);
        System.out.println("name6:key:"+temp);
        String name6=map.get(temp);
        if(name6==null){
            temp=cardNo.substring(0,7);
            System.out.println("name7:key:"+temp);
            String name7=map.get(temp);
            if(name7==null){
                temp=cardNo.substring(0,8);
                System.out.println("name8:key:"+temp);
                String name8=map.get(temp);
                if(name8==null){
                    temp=cardNo.substring(0,9);
                    System.out.println("name9:key:"+temp);
                    String name9=map.get(temp);
                    if(name9==null){
                        System.out.println("Kong");
                    }else{
                        System.out.println("name9 --- :" + name9);
                    }
                }else{
                    System.out.println("name8 --- :" +name8);
                }
            }else{
                System.out.println("name7 --- : " +name7);
            }
        }
        System.out.println("name6 --- :" + name6);
    }
}
