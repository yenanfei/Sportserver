package com.dao;

import com.beans.*;
import com.JDBC.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class locate_dao extends abstruct_dao{
    private locate Locate;

    public locate_dao(locate Locate){
        super();
        this.Locate=Locate;
    }

    public locate_dao(Connection conn, locate Locate){
        super(conn);
        this.Locate=Locate;
    }

    public void insertpos(String posx,String posy,String time,String state,String name){
        /*
        * 将位置信息插入数据库
        * */
            //Statement stat = conn.createStatement();
            String sql = String.format("INSERT INTO tal_sport_message ( posx , posy , stime ,sportId,state) VALUES(%s,%s,\"%s\",%s,%s);", posx, posy, time,name,state);
           // ResultSet rs = stat.executeQuery(sql);
            abstruct_dao.runSQL(sql);
            //while(rs.next()){
             //   double i=rs.getDouble("jindu");
              //  double j=rs.getDouble("weidu");
            //}
    }

    public static void inserttal_sport(String speed1,String speed2,String time,String name){
        String sql = String.format("INSERT INTO %s ( speed1,speed2, stime, name ) VALUES(%s,%s,\"%s\",%s);",table_tal_sport, speed1, speed2, time,name);
        // ResultSet rs = stat.executeQuery(sql);
//        System.out.println(sql);
        abstruct_dao.runSQL(sql);
    }

    public static Double[] searchspeed1(int _begin, int _end){
        /*
        * 返回结果集
        * */
        try {
            abstruct_dao.connect();
            Statement stat = conn.createStatement();
            String sql = String.format("select * from %s order by stime limit ?,?;",table_tal_sport);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,_begin-1);
            ps.setInt(2,_end-1);
            ResultSet rs = ps.executeQuery();
            List<Double> ans= new Vector();
            while(rs.next()){
                ans.add(rs.getDouble("speed1"));
                //ans.add(rs.getDouble("speed2"));
            }
            Double[] array =new Double[ans.size()];
            return ans.toArray(array);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Double[] searchspeed2(int _begin, int _end){
        /*
        * 返回结果集
        * */
        try {
            Statement stat = conn.createStatement();
            String sql = String.format("select * from %s order by stime limit ?,?;",table_tal_sport);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,_begin-1);
            ps.setInt(2,_end-1);
            ResultSet rs = ps.executeQuery();
            List<Double> ans= new Vector();
            while(rs.next()){
                ans.add(rs.getDouble("speed2"));
                //ans.add(rs.getDouble("speed2"));
            }
            Double[] array =new Double[ans.size()];
            return ans.toArray(array);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
