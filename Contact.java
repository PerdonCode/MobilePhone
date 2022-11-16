package mobilePhone;

public class Contact {

    private static String name;
    private static String phoneNumber;

    public Contact(String name, String phoneNumber) {
        Contact.name = name;
        Contact.phoneNumber = phoneNumber;
    }

    public static String getName() {
        return name;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }

}
