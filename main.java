package mobilePhone;

import java.util.Scanner;

public class main {
    public static final String EXISTING_CONTACT_MESSAGE = "enter existing contact name: ";
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mp = new MobilePhone("0633349194");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();
        while (!quit){
            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 1:
                    addNewContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    mp.printContacts();
                    break;
                case 6:
                    System.out.println("shutting down....");
                    quit = true;
                    break;
            }
        }
    }

    public static void printActions() {
        System.out.println("choose a number");
        System.out.println("1. to add a contact");
        System.out.println("2. to update a contact");
        System.out.println("3. te remove a contact");
        System.out.println("4. query contact");
        System.out.println("5. to print all contacts");
        System.out.println("6. to quit ");
    }

    public static void addNewContact() {
        System.out.println("type the name ");
        String name = scanner.nextLine();
        System.out.println("type the number ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mp.addNewContact(newContact)) {
            System.out.println("contact " + name + " set with phonenumber : " + number);
        } else
            System.out.println("niet gelukt" + name + "bestaat al ");
    }

    public static void updateContact() {
        System.out.println(EXISTING_CONTACT_MESSAGE);
        String name = scanner.nextLine();
        Contact existingContactRecord = mp.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phoneNumber");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mp.updateContact(existingContactRecord, newContact)) {
            System.out.println("succesfully updated record");
        } else {
            System.out.println("Error updating record. ");
        }
    }

    public static void removeContact() {
        System.out.println(EXISTING_CONTACT_MESSAGE);
        String name = scanner.nextLine();
        Contact existingContactRecord = mp.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found");
            return;
        }
        if (mp.removeContact(existingContactRecord)) {
            System.out.println("succesfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    public static void queryContact() {
        System.out.println(EXISTING_CONTACT_MESSAGE);
        String name = scanner.nextLine();
        Contact existingContactRecord = mp.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("Name: " + Contact.getName() + " Phone number is: " + Contact.getPhoneNumber());
    }
}
