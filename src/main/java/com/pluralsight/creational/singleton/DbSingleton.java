package com.pluralsight.creational.singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingleton {

  private static volatile DbSingleton instance = null;
  private static volatile Connection conn = null;
  private static final String mySQLUser = "dyakogeorgiev";
  private static final String mySQLPwd = "123456789Dyako!";
  private static final String mySQLCS = "jdbc:mysql://localhost:3306/world";


  private DbSingleton() {
    if(conn != null) {
      throw new RuntimeException("Use getConnection() method to create");
    }

    if(instance != null) {
      throw new RuntimeException("Use getInstance() method to create");
    }
  }

  public static DbSingleton getInstance() {
    if(instance == null) {
      synchronized(DbSingleton.class) {
        if(instance == null) {
          instance = new DbSingleton();
        }
      }
    }

    return instance;
  }

  public Connection getConnection() {
    if(conn == null) {
      synchronized (DbSingleton.class) {
        if(conn == null) {
          try {
            conn = DriverManager.getConnection(mySQLCS,mySQLUser,mySQLPwd);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return conn;
  }
}
