package com.servlet;

import com.beans.locate;
import com.dao.locate_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "savespeed")
public class savespeed  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String speed1 = request.getParameter("speed1");
        System.out.println("步/分"+speed1);
        String speed2 = request.getParameter("speed2");
        System.out.println("公里/小时"+speed1);

        //JSONArray book_json=null;

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("application/json");
        Writer out = response.getWriter();
        //assert book_json != null;
        //out.write(book_json.toString());
        out.write(String.format("speed1:%s\nspeed2:%s", speed1, speed2));
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String time = dateFormat.format( now );
        System.out.println("时间"+time);
        out.flush();
        out.close();
        response.flushBuffer();
        //test.insertpos(lontitude,latitude,time);
        locate_dao.inserttal_sport(speed1,speed2,time,"15624952055");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
