package com.bridgelabz.codinclub.utils;

import com.bridgelabz.codinclub.modles.Person;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

/**
@author santosh
*/
public class CSVWriter {

    public static void writeAll(ArrayList<Person> persons){
        if(persons.isEmpty()){
            System.out.println("nothing in file");
        }
        else{
            try{
                PrintWriter pw = new PrintWriter("com/bridgelabz/codeinclub/utils/data/AddressBook.csv");
                    for(Person person : persons){
                        String csv = person.getFirstName()+","+person.getLastName()+","+person.getAddress()+","+person.getCity()+","+person.getState()+","+person.getZip()+","+person.getPhone()+",;";
                        pw.println(csv);
                    }
                    pw.close();
                }catch(IOException e){
                    System.out.println("Error: File not found");
                }
            
        }
    }

}