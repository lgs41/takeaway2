package com.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: VarifyCodeController
 * @Auther: lgs
 * @Description:
 * @DateTime: 2023/6/6 15:31
 **/
@Controller
public class VarifyCodeController {

     @RequestMapping("/getVarifyCode")
     public void getVarifyCode(HttpSession session, HttpServletResponse response) throws IOException {

        //产生一个图片对象
        BufferedImage bi = new BufferedImage(46,20,BufferedImage.TYPE_INT_RGB);

        //产生一个画笔
        Graphics2D g = (Graphics2D) bi.getGraphics();

        //设置画笔颜色
        g.setColor(Color.white);

        //填充背景颜色
        g.fillRect(0,0,46,20);

        //设置画笔为蓝色
        g.setColor(Color.blue);

        //产生验证码，4位
        String str="23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";

        StringBuilder s = new StringBuilder();
        for(int i=0;i<4;i++){
            //产生随机下标
            int index = new Random().nextInt(str.length());

            String randomChar = str.charAt(index)+"";

            s.append(randomChar);
        }

        g.setFont(new Font("Arial", Font.BOLD, 14));

        g.drawString(s.toString(),4,16);

        session.setAttribute("varifyCode",s.toString());

        System.out.println("验证码" +s.toString());

        ImageIO.write(bi,"JPEG",response.getOutputStream());


    }

}
