package com.pluralsight.creational.factory;

import java.util.Calendar;

public class FactoryEverydayDemo {
  public static void main (String[] args) {
    //Factory method example
    Calendar cal = Calendar.getInstance();

    System.out.println(cal);

    System.out.println(Calendar.DAY_OF_MONTH);
  }
}
