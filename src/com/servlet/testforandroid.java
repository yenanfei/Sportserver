package com.servlet;

import java.io.IOException;

import com.beans.locate;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.*;

/**
 * Created by hasee on 2017/8/9.
 */
@WebServlet(name = "testforandroid")
public class testforandroid extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String latitude = request.getParameter("latitude");
        System.out.println("纬度"+latitude);
        String lontitude = request.getParameter("lontitude");
        System.out.println("经度"+lontitude);
        String state = request.getParameter("state");
        System.out.println("状态"+lontitude);
        String username = request.getParameter("username");
        System.out.println("用户名"+lontitude);

        //JSONArray book_json=null;

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("application/json");
        Writer out = response.getWriter();
        //assert book_json != null;
        //out.write(book_json.toString());
        out.write(String.format("latitude:%s\nlontitude:%s", latitude, lontitude));
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String time = dateFormat.format( now );
        System.out.println("时间"+time);
        locate Locate=new locate();
        Locate.setPosx(lontitude);
        Locate.setPosy(latitude);
        Locate.setStime(time);
        out.flush();
        out.close();
        response.flushBuffer();
        locate_dao test=new locate_dao(Locate);
        test.insertpos(lontitude,latitude,time,state,username);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
