package mobilePhone;

import java.util.ArrayList;


public class MobilePhone {
    private static String myNumber;
    private static ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        MobilePhone.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("contact bestaat al");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (myContacts.contains(oldContact)) {
            myContacts.set(myContacts.indexOf(oldContact), newContact);
            return true;
        } else {
            System.out.println(Contact.getName() + " Contact was not found");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        } else {
            System.out.println(Contact.getName() + " was not found");
            return false;
        }
    }

    private int findContact(Contact contact) {
        return (myContacts.contains(contact) ? myContacts.indexOf(contact) : -1);
    }

    private int findContact(String contactName) {
        for(Contact contact : myContacts) {
            if(contact.getName().equals(contactName)) {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Object queryContact(Contact contact) {
        int position = findContact(contact);
        return (position < 0 ? null : myContacts.get(position));
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }


    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println((myContacts.indexOf(contact) + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}