package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookUse {
   static Date d;
   static ArrayList<Book> books = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String name;
    static String type;
    static double price;
    static String author;
    static int enter;
    static boolean isAvilable= true;
    static public int enter() {
        System.out.println("Are you 1- admin or 2- user?");

        do {
            try {
                enter = scan.nextInt();;
                if (enter < 1 || enter > 2) {
                    Exception e = new Exception();
                    throw e;
                }
                isAvilable = false;
            } catch (Exception e) {
                scan.nextLine();
                System.err.println("Enter your choice number");
                isAvilable = true;
            }
        } while (isAvilable);
        return enter;
    }

    static public void useArrayList() {
        scan.nextLine();
        do {
            System.out.println("Enter book name , type , price and author in by order when you finish enter end and press enter to continue");
            name = scan.nextLine();

            type = scan.nextLine();
            price = scan.nextDouble();
            author = scan.nextLine();
            books.add(new Book(name, type, price, author));
            scan.nextLine();
            String con = scan.nextLine();
            if (con.equals("end")) {
                break;
            }
        } while (true);
    }

    static public void remove() {
        do {
            System.out.println("Enter book name and book type");
            name = scan.nextLine();
            type = scan.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if (name.equals(books.get(i).getName()) && type.equals(books.get(i).getType())) {
                    books.remove(i);
                    System.out.println("The book has removed successfully enter end to exit");
                } else System.out.println("You can't remove book doesn't exist in library");
            }

            String con = scan.nextLine();
            if (con.equals("end")) {
                break;
            }
        } while (true);

    }

    static public void modify() {
        do {
            System.out.println("Enter book name and book type");
            name = scan.nextLine();
            type = scan.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getName().equals(name) &&books.get(i).getType().equals(type)){

                    System.out.println("Enter new book name , type , price and author in by order when you finish enter end and press enter to continue");
                    name = scan.nextLine();
                    type = scan.nextLine();
                    price = scan.nextDouble();
                    scan.nextLine();
                    author = scan.nextLine();
                    books.get(i).setName(name);
                    books.get(i).setType(type);
                    books.get(i).setPrice(price);
                    books.get(i).setAuthor(author);

                } else System.out.println("You can't modify book doesn't exist in library");
            }
            String con = scan.nextLine();
            if (con.equals("end")) {
                break;
            }
        } while (true);
    }

    static public void Borrow() {
        scan.nextLine();
        System.out.println("Enter book name");
        name = scan.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (name.equals(books.get(i).getName())) {
                if (books.get(i).isAvilable()) {
                    d = new Date();
                    books.get(i).setReg(d);
                    System.out.println("You have borrowed this book for 15 days after this you will pay a fine");
                    books.get(i).setAvilable(false);
                    books.get(i).setBookCost(books.get(i).getPrice());
                    books.get(i).setBookBorrow(books.get(i).getPrice());
                } else System.out.println("Not avaliable");
            } else continue;
        }
    }

    static public void return_book() {
        scan.nextLine();
        System.out.println("Enter book name");
        name = scan.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (name.equals(books.get(i).getName())) {
                if (!books.get(i).isAvilable()) {
                    d = new Date();
                    books.get(i).setRe(d);
                    books.get(i).setAvilable(true);
                    long f_D = getDifferenceDays(books.get(i).getRe(), books.get(i).getReg());
                    books.get(i).setFineDate(f_D);
                    if (books.get(i).getFineDate() > 20 && books.get(i).getType().equals("book")) {
                        books.get(i).setFine(books.get(i).getPrice() + (books.get(i).getPrice() * .05));
                        books.get(i).setBookFine(books.get(i).getBookFine() + books.get(i).getFine());
                        System.out.println("You will pay fine for being late it cost " + books.get(i).getFine());
                    } else if (books.get(i).getFineDate() > 12 && (books.get(i).getType().equals("magazine") || books.get(i).getType().equals("booklet"))) {
                        books.get(i).setFine(books.get(i).getPrice() + (books.get(i).getPrice() * .03));
                        books.get(i).setBookFine(books.get(i).getBookFine() + books.get(i).getFine());
                        System.out.println("You will pay fine for being late it cost " + books.get(i).getFine());
                    } else {
                        System.out.println("Thank you for return book in time");
                    }
                }
                } else System.out.println("You can't return book you don't borrow it");
            }
        }


    public static long getDifferenceDays(Date d1, Date d2) {
        long def = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(def, TimeUnit.DAYS);
    }

    static public void Search(int x) {
        System.out.println(books.get(x).toString());
    }

    static  public void SearchAuthor() {
        System.out.println("Enter Author name");
        name = scan.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().toLowerCase().contains(name)) {
                System.out.println(books.get(i).getName() + " "+" book Type " + books.get(i).getType() + " " + books.get(i).getPrice());
            }
        }
    }

    static public void SearchType() {
        System.out.println("Enter type of book");
        name = scan.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getType().toLowerCase().contains(name)) {
                System.out.println(books.get(i).getName() + " "+" written by " + books.get(i).getAuthor() + " " + books.get(i).getPrice());
            }
        }
    }

    static public void searchByBook() {
        System.out.println("Enter book name");
        name = scan.nextLine();
        String n2 = name.toLowerCase();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().toLowerCase().contains(n2)) {
                    Search(i);
                }
            }
        }


    static public void paymentSystem() {
        double totalCost = 0;
        double totalBorrow = 0;
        double totalFine = 0;
        for (int i = 0; i < books.size(); i++) {
            totalCost += books.get(i).getBookCost();
            if(!books.get(i).isAvilable()) {
                totalBorrow += books.get(i).getBookBorrow();
            }
            totalFine += books.get(i).getBookFine();
        }
        System.out.println("Purchases : ");
        for (int i = 0; i < books.size(); i++) {

            System.out.println("Book : " + books.get(i).getName() + " It cost " + books.get(i).getPrice());
        }
        System.out.println("Borrow : ");
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isAvilable()) {
                System.out.println("Student borrowed Book : " + books.get(i).getName() + " It cost " + books.get(i).getPrice());
            }
        }
        if (totalFine > 0) {
            System.out.println("Fines : ");
            for (int i = 0; i < books.size(); i++) {

                System.out.println("Student's Fine of Book " + books.get(i).getName() + " It cost " + books.get(i).getFine());
            }
        } else System.out.println("Total fine = 0");


        System.out.println("total price of books in library" + " " + totalCost);
        System.out.println("total price of borrow books" + " " + totalBorrow);
        System.out.println("total price of fine" + " " + totalFine);
        System.out.println("total budget" + " " + ((totalFine+totalBorrow)-totalCost));

    }

    static public void show() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
    }
    static public void showAvilable(){
        for (int i = 0; i <books.size() ; i++) {
            if (books.get(i).isAvilable()){
                Search(i);
            }
        }
    }
    static public void showNotAvilable(){
        for (int i = 0; i <books.size() ; i++) {
            if (!books.get(i).isAvilable()){
                Search(i);
            }
        }
    }
}
