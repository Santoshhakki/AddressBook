package com.bridgelabz.codinclub.services;

import com.bridgelabz.codinclub.modles.Person;
import com.bridgelabz.codinclub.utils.CSVWriter;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.utils.LoadData;
import java.util.ArrayList;
import java.util.Scanner;

/**
@author santosh
*/
public class AddressBook implements AddressBookService{
    final private ArrayList<Person> addressBook = new ArrayList<>();

    @Override
    public void addPerson() {
        // had some problem so added this line to patch it up;
        AddressBookUtil.getUserString();

        System.out.print("Enter First name: ");
        final String firstName = AddressBookUtil.getUserString();

        System.out.print("Enter Last name: ");
        final String lastName = AddressBookUtil.getUserString();

        System.out.print("Enter Address: ");
        final String address = AddressBookUtil.getUserString();

        System.out.print("Enter  City: ");
        final String city =  AddressBookUtil.getUserString();

        System.out.print("Enter State: ");
        final String state = AddressBookUtil.getUserString();

        System.out.print("Enter Zip code: ");
        final String zip = AddressBookUtil.getUserString();

        System.out.print("Enter Phone number: ");
        final String phone = AddressBookUtil.getUserString();

        final Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBook.add(person);
    }

    @Override
    public void editPerson() {

    }

    @Override
    public void deletePerson() {
        AddressBookUtil.getUserString();
        display();
        System.out.print("Enter firstName to delete: ");
        String firstName = AddressBookUtil.getUserString();
        Person obj = serach(firstName);
        if(obj != null ){
            addressBook.remove(obj);
            System.out.println("contact deleted");
        }
        else{
            System.out.println("contact not found.");
        }
    }

    @Override
    public void display(){
        for(Person obj : addressBook) {
            System.out.println("Name: "+obj.getName());
            System.out.println("Address: "+obj.getAddress());
            System.out.println("Phone: "+obj.getPhone());
        }
    }

    @Override
    public void save(){
        CSVWriter.writeAll(addressBook);
    }

    @Override
    public void loadData(){
        ArrayList<Person> temp = LoadData.load();
        if(temp.isEmpty()){
            System.out.println("Nothing to load from file.");
        }
        else {
            if(!addressBook.isEmpty()){
                addressBook.clear();
            }
            for(Person obj : temp){
                addressBook.add(obj);
            }
            System.out.println("Data loaded from file");
        }
    }

    private Person serach(String firstName){
        Person returnObj = null;
        for(Person obj : addressBook){
            if(firstName.equalsIgnoreCase(obj.getFirstName())){
                returnObj = obj;
                break;
            }
        }
        return returnObj;
    }
}
