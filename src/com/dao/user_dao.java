package com.dao;

public class user_dao extends abstruct_dao {
    public void insertuser(String name,String password,String phone,String gender,String age,String height,String weight,String time){
        /*
        * 将位置信息插入数据库
        * */
        //Statement stat = conn.createStatement();
        String sql = String.format("INSERT INTO tal_user ( name , password , phone ,gender,age,height,weight,stime) VALUES(\"%s\",\"%s\",\"%s\",\"%s\",%s,%s,%s,\"%s\");", name, password, phone,gender,age,height,weight,time);
        // ResultSet rs = stat.executeQuery(sql);
        abstruct_dao.runSQL(sql);
        //while(rs.next()){
        //   double i=rs.getDouble("jindu");
        //  double j=rs.getDouble("weidu");
        //}
    }
}
