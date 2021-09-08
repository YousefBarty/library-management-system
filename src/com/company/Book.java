package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book {
     String name;
     String type;
     Date reg;
     Date re;
     double price;
     double fine;
     String author;
     long fineDate;
     double bookCost;
     double bookBorrow;
     double bookFine;
     boolean avilable = true;
     static int pass=4545;

    public Book(String name, String type, double price, String author) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.author = author;
        bookCost += price;
    }
     public String getName() {
        return name;
    }
     public void setName(String name) {
        this.name = name;
    }
     public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
     public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
       public double getFine() {
        return fine;
    }
    public void setFine(double fine) {
        this.fine = fine;
    }
     public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
     public  double getBookCost() {
        return bookCost;
    }
    public  void setBookCost(double bookCost) {
        this.bookCost = bookCost;
    }
    public  double getBookBorrow() {
        return bookBorrow;
    }
    public  void setBookBorrow(double bookBorrow) {
        this.bookBorrow = bookBorrow;
    }
    public  double getBookFine() {
        return bookFine;
    }
    public  void setBookFine(double bookFine) {
        this.bookFine = bookFine;
    }
     public boolean isAvilable() {
        return avilable;
    }
     public void setAvilable(boolean avilable) {
        this.avilable = avilable;
    }
     public Date getReg() {
        return reg;
    }
    public void setReg(Date reg) {
        this.reg = reg;
    }
     public Date getRe() {
        return re;
    }
    public void setRe(Date re) {
        this.re = re;
    }
     public long getFineDate() {
        return fineDate;
    }
     public void setFineDate(long fineDate) {
        this.fineDate = fineDate;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
