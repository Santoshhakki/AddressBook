package com.bridgelabz.codinclub.utils;

import com.bridgelabz.codinclub.modles.Person;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
@author santosh
*/
public class LoadData{
    final private static ArrayList<Person> persons = new ArrayList<Person>();

    private static void split(String data){
        ArrayList<String> person = new ArrayList<>();
        int pos = 0;
        String temp = "";
        while(data.charAt(pos) != ';'){
            while(data.charAt(pos) != ',' && data.charAt(pos) != ';'){
                temp = temp + data.charAt(pos);
                pos++;
            }
            person.add(temp);
            temp = "";
            pos++;
        }
        addToList(person);
    }

    private static void addToList(ArrayList<String> data){
        Person person = new Person(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6));
        persons.add(person);
    }


    public static ArrayList<Person> load(){
        try{
            File data = new File("com/bridgelabz/codeinclub/utils/data/AddressBook.csv");
            Scanner fileReader = new Scanner(data);
            while(fileReader.hasNextLine()){
                split(fileReader.nextLine());
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        return persons;
    }
}