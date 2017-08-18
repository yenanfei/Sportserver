package com.dao;

import com.JDBC.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hasee on 2017/5/19.
 */
public abstract class abstruct_dao {

    protected static final String database_sport ="sport";
    protected static final String table_tal_sport_message="tal_sport_message";
    protected static final String table_tal_sport="tal_sport";

    protected static Connection conn = null;
    public static Connection getConn(){
        return conn;
    }

    public static void setConn(Connection conn){
        abstruct_dao.conn=conn;
    }

    public abstruct_dao(){
        try {
            if (conn==null) conn= JDBC.getConnection();
            Statement stat = conn.createStatement();
            String sql = String.format("use %s;", database_sport);
            boolean flag=stat.execute(sql);
            if (flag) System.err.println("Can't find database \""+ database_sport +"\".");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public abstruct_dao(Connection conn){
        try {
            conn = conn;
            Statement stat = conn.createStatement();
            String sql = String.format("use %s;", database_sport);
            boolean flag=stat.execute(sql);
            if (flag) System.err.println("Can't find database \""+ database_sport +"\".");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void close(){
        if (conn!=null) JDBC.close(conn,null);
        conn=null;
    }

    public static void connect(){
        if (conn==null) conn= JDBC.getConnection();
    }

    public static void runSQL(String sql){
        connect();
        try {
            Statement stat = conn.createStatement();
            boolean flag=stat.execute(sql);
            if (flag) System.err.println("Cannot run the sql "+sql+" .");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
