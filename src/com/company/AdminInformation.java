package com.company;

import java.util.Scanner;

public class AdminInformation extends BookUse{
    static int choice;
    static int c;
    static public int Choice() {
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter number of your choice");
                System.out.println("1- Search");
                System.out.println("2- Add");
                System.out.println("3- Modify");
                System.out.println("4- Delete");
                System.out.println("5- Payment system");
                System.out.println("6- Show");
                System.out.println("7- Exit");
                boolean con;
                do {
                    try {
                        choice = scan.nextInt();
                        if (choice < 1 || choice > 7) {
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
                if (choice == 1) {
                    System.out.println("1- Search by book");
                    System.out.println("2- Search by author");
                    System.out.println("3- Search by Type");
                    do {
                        try {
                            c = scan.nextInt();
                            if (c < 1 || c > 3) {
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
                        scan.nextLine();
                        searchByBook();
                    } else if (c == 2) {
                        scan.nextLine();
                        SearchAuthor();
                    } else if (c == 3) {
                        scan.nextLine();
                        SearchType();

                    }
                }else if (choice == 2){
                    useArrayList();
                }else if (choice==3){
                    modify();
                }else if (choice==4){
                    remove();
                }else if (choice==5){
                    paymentSystem();
                }
                else if(choice==6){
                    System.out.println("1- Show all books");
                    System.out.println("2- Show avialable book");
                    System.out.println("3- Show borrowed book");
                    do {
                        try {
                            c = scan.nextInt();
                            if (c < 1 || c > 3) {
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
                    } else if (c == 3) {
                        showNotAvilable();
                    }

                }

                } while (choice<7);
            return choice;
        }
}
