package com.bridgelabz.codinclub.utils;

import java.util.Scanner;

public final class AddressBookUtil {
    private final static Scanner s = new Scanner(System.in);

    private AddressBookUtil(){

    }

    public static int getUserNumber(){
        return s.nextInt();
    }

    public static String getUserString(){
        String temp = s.nextLine();
        return temp;
    }
}