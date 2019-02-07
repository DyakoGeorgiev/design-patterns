package com.pluralsight.creational.prototype;

public class Book extends Item {
  private int NumberOfPages;

  public int getNumberOfPages () {
    return NumberOfPages;
  }

  public void setNumberOfPages (int numberOfPages) {
    this.NumberOfPages = numberOfPages;
  }
}
