
    import java.util.ArrayList;
    import java.util.Scanner;

    class Contact {
        String name;
        String phoneNumber;
        String email;

        // Constructor
        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        // Method to display contact information
        public void displayContact() {
            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Email: " + email);
        }
    }

    public class ContactManagementSystem {

        private static ArrayList<Contact> contactList = new ArrayList<>();
        private static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println("\n--- Contact Management System ---");
                System.out.println("1. Add Contact");
                System.out.println("2. View All Contacts");
                System.out.println("3. Update Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character after nextInt()

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        viewContacts();
                        break;
                    case 3:
                        updateContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        keepRunning = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            sc.close();
        }

        // Method to add a contact
        private static void addContact() {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            Contact newContact = new Contact(name, phoneNumber, email);
            contactList.add(newContact);
            System.out.println("Contact added successfully.");
        }

        // Method to view all contacts
        private static void viewContacts() {
            if (contactList.isEmpty()) {
                System.out.println("No contacts available.");
            } else {
                System.out.println("\n--- Contact List ---");
                for (int i = 0; i < contactList.size(); i++) {
                    System.out.println("Contact " + (i + 1) + ":");
                    contactList.get(i).displayContact();
                    System.out.println();
                }
            }
        }

        // Method to update a contact
        private static void updateContact() {
            if (contactList.isEmpty()) {
                System.out.println("No contacts available to update.");
                return;
            }
            System.out.print("Enter the contact number to update (1-" + contactList.size() + "): ");
            int index = sc.nextInt() - 1;
            sc.nextLine(); // Consume the newline character

            if (index >= 0 && index < contactList.size()) {
                Contact contact = contactList.get(index);

                System.out.println("Updating contact:");
                contact.displayContact();
                System.out.print("Enter new name (leave empty to keep unchanged): ");
                String name = sc.nextLine();
                if (!name.isEmpty()) contact.name = name;

                System.out.print("Enter new phone number (leave empty to keep unchanged): ");
                String phoneNumber = sc.nextLine();
                if (!phoneNumber.isEmpty()) contact.phoneNumber = phoneNumber;

                System.out.print("Enter new email (leave empty to keep unchanged): ");
                String email = sc.nextLine();
                if (!email.isEmpty()) contact.email = email;

                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }

        // Method to delete a contact
        private static void deleteContact() {
            if (contactList.isEmpty()) {
                System.out.println("No contacts available to delete.");
                return;
            }
            System.out.print("Enter the contact number to delete (1-" + contactList.size() + "): ");
            int index = sc.nextInt() - 1;
            sc.nextLine(); // Consume the newline character

            if (index >= 0 && index < contactList.size()) {
                contactList.remove(index);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }
    }
        
