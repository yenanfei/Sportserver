package com.servlet;

import com.dao.locate_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "getspeed12")
public class getspeed12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("application/json");
        Writer out = response.getWriter();
        Double[] ans1=locate_dao.searchspeed1(1,10);
        out.write(Arrays.toString(ans1));
        out.write("\n");
        Double[] ans2=locate_dao.searchspeed1(1,10);
        out.write(Arrays.toString(ans2));
        out.flush();
        out.close();
        response.flushBuffer();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
