
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUItis implements Serializable{

    //COnnect DB amazon
    public static Connection openConnection1(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://myrdstest.cpyn1ihknlei.us-east-1.rds.amazonaws.com:1433; databaseName=ResourceSharing";
            Connection con= DriverManager.getConnection(url,"TaiPham","Phamviettai09052000");
      //      System.out.println("Connect Successful!!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public static Connection openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433; databaseName=ResourceSharing";
            Connection con= DriverManager.getConnection(url,"sa","123");
      //      System.out.println("Connect Successful!!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        DBUItis db=new DBUItis();
        System.out.println(db.openConnection());
    }
}
