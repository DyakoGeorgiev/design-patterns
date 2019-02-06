package com.pluralsight.creational.singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

  public static void main(String[] args) {
    DbSingleton instance = DbSingleton.getInstance();

    long timeBefore = 0;
    long timeAfter = 0;

    System.out.println(instance);

    timeBefore = System.currentTimeMillis();
    System.out.print("The time required to connect is: ");
    Connection conn = instance.getConnection();
    timeAfter = System.currentTimeMillis();

    System.out.println(timeAfter - timeBefore);

    Statement sta;
    try (
      Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = statement.executeQuery("Select * from country limit 10")
    ) {

      String format = "%-7s %-60s %-60s %-40s\n";

      rs.beforeFirst();
      System.out.println("First 10 rows");

      while (rs.next()) {
        String code = rs.getString("Code");
        String name = rs.getString("name");
        String continent = rs.getString("continent");
        Integer population = rs.getInt("Population");
        System.out.format(format, code, name, continent, population);
      }

      timeBefore = System.currentTimeMillis();
      System.out.print("The required time to connect (second time) is: ");
      conn = instance.getConnection();
      timeAfter = System.currentTimeMillis();

      System.out.println(timeAfter - timeBefore);

      System.out.println(conn);
    } catch (SQLException e) {
      System.out.println(e.getSQLState());
    }
  }
}
