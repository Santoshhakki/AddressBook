package com.bridgelabz.codinclub.main;

import com.bridgelabz.codinclub.utils.LoadData;
import com.bridgelabz.codinclub.utils.AddressBookUtil;
import com.bridgelabz.codinclub.services.AddressBookService;
import com.bridgelabz.codinclub.services.AddressBook;

/**
@author Santosh
*/
public class Main {
    public static void main(String[] args) {
        final AddressBookService addressBookService = new AddressBook();
        addressBookService.loadData();
        while(true) {
            System.out.println("1:Add Details");
			System.out.println("2:display Details");
			System.out.println("3:edit contacts");
			System.out.println("4:delete contacts");
			System.out.println("5:exit");
			System.out.println("enter your choice");
            final int choice = AddressBookUtil.getUserNumber();
            switch(choice) {
                case 1:
                    addressBookService.addPerson();
                    System.out.println("successfully added");
                break;
                case 2:
                    System.out.println("here the details ");
                    addressBookService.display();
                break;
                case 3:
                    System.out.println("edit the details here");
                    addressBookService.editPerson();
                break;
                case 4:
					System.out.println("Delete the contacts");
                    addressBookService.deletePerson();
                break;
                case 5:
                    addressBookService.save();
                    System.out.println("going out!");
                    System.exit(0);
                default:
                    System.out.println("Error: Invalid Entry, Choose right option");
            }
        }

    }
}