package com.servlet;

//import com.beans.locate;
import com.dao.user_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "user_s")
public class user_s  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("na");
        System.out.println("用户名："+name);
        String password = request.getParameter("pa");
        System.out.println("密码："+password);
        String phone = request.getParameter("ph");
        System.out.println("电话："+phone);
        String gender = request.getParameter("ge");
        System.out.println("性别："+gender);
        String age = request.getParameter("ag");
        System.out.println("年龄："+age);
        String height = request.getParameter("he");
        System.out.println("身高："+height);
        String weight = request.getParameter("we");
        System.out.println("体重："+weight);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("application/json");
        Writer out = response.getWriter();
        out.write(String.format("name:%s注册成功", name));
        out.flush();
        out.close();


        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String time = dateFormat.format( now );
        System.out.println("注册时间："+time);
        response.flushBuffer();
        user_dao test=new user_dao();
        test.insertuser(name,password,phone,gender,age,height,weight,time);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
