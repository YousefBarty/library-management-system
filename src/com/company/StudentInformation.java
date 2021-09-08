package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformation extends BookUse{
    static Scanner scan = new Scanner(System.in);
    static    int choice;
    static int c;
    ArrayList<Person> students = new ArrayList<>();

    static public int choice() {
        do {
            System.out.println("Enter number of your choice");
            System.out.println("1- Search");
            System.out.println("2- Borrow");
            System.out.println("3- Return");
            System.out.println("4- Show books");
            System.out.println("5- Exit");
            boolean con;
            do {
                try {

                    choice = scan.nextInt();
                    if (choice<1||choice>5) {
                        Exception e = new Exception();
                        throw e;
                    }
                    con = false;
                } catch (Exception e) {
                    scan.nextLine();
                    System.err.println("Enter your choice number");
                    con = true;
                }
            } while (con);
            if (choice == 1){
                System.out.println("1- Search by book");
                System.out.println("2- Search by author");
                System.out.println("3- Search by Type");
                do {
                    try {
                        c = scan.nextInt();
                        if (c<1||c>3) {
                            Exception e = new Exception();
                            throw e;
                        }
                        con = false;
                    } catch (Exception e) {
                        scan.nextLine();
                        System.err.println("Enter your choice number");
                        con = true;
                    }
                } while (con);
                if (c == 1){
                    searchByBook();
                }else if (c == 2){
                    SearchAuthor();
                }else if (c==3){
                    SearchType();
                }
            }else if (choice==2){
                Borrow();
            }else if (choice==3){
                return_book();
            }else if(choice==4) {
                System.out.println("1- Show all books");
                System.out.println("2- Show avialable book");
                do {
                    try {
                        c = scan.nextInt();
                        if (c < 1 || c > 2) {
                            Exception e = new Exception();
                            throw e;
                        }
                        con = false;
                    } catch (Exception e) {
                        scan.nextLine();
                        System.err.println("Enter your choice number");
                        con = true;
                    }
                } while (con);
                if (c == 1) {
                    show();
                } else if (c == 2) {
                    showAvilable();
                }
            }
        }while (choice<5);
        return choice;
    }
}
