/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author siddharth
 */
public abstract class Table {

    Connection conn = null;
    Statement stmt = null;

    public void initialiseJDBC() {
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?user=dbms&password=123");

            stmt = conn.createStatement();
//      String sql;
//      sql = "SELECT name, id, age FROM emp";
//      ResultSet rs = stmt.executeQuery(sql);
//      while(rs.next()){
//         //Retrieve by column name
//          String name = rs.getString("name");
//         int id  = rs.getInt("id");
//         int age = rs.getInt("age");
//         
//         //String last = rs.getString("last");
//
//         //Display values
//         System.out.print("ID: " + id);
//         System.out.print(", Age: " + age);
//         System.out.println(", First: " + name);
//         //System.out.println(", Last: " + last);
//      }
//      rs.close();
//      stmt.close();
//      conn.close();
//   }finally{
//      //finally block used to close resources
//      try{
//         if(stmt!=null)
//            stmt.close();
//      }catch(SQLException se2){
//      }// nothing we can do
//      try{
//         if(conn!=null)
//            conn.close();
//      }catch(SQLException se){
//         se.printStackTrace();
//      }//end finally try
//   }//end try
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void insert();

    public abstract void delete();

    public abstract void update();

    public abstract void search();
}
