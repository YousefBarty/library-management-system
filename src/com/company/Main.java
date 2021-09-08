package com.company;

import com.company.AdminInformation;
import com.company.BookUse;
import com.company.StudentInformation;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        BookUse b = new BookUse();
        do {
            int ent = b.enter();
            if (ent == 1) {
                b = new AdminInformation();
                ((AdminInformation) b).Choice();
            } else if (ent == 2) {
                b = new StudentInformation();
                ((StudentInformation) b).choice();
            }
        } while (true); }}
