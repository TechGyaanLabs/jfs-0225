package com.careerit.cj.cbook;

import com.careerit.cj.util.DbUtil;

import java.util.List;
import java.util.Scanner;

public class ContactBookManager {

    public static void main(String[] args) {

        ContactDao dao = new ContactDaoImpl(DbUtil.getInstance());
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.println("Enter your choice :");
            int ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Enter name :");
                    String name = scanner.nextLine();
                    System.out.println("Enter email :");
                    String email = scanner.nextLine();
                    System.out.println("Enter mobile :");
                    String mobile = scanner.nextLine();
                    Contact contact = new Contact();
                    contact.setName(name);
                    contact.setEmail(email);
                    contact.setMobile(mobile);
                    dao.insertContact(contact);
                    System.out.println("Contact added successfully");
                    break;
                case 2:
                    List<Contact> contacts = dao.selectAll();
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        contacts.forEach(c -> {
                            System.out.println("Id :" + c.getId());
                            System.out.println("Name :" + c.getName());
                            System.out.println("Email :" + c.getEmail());
                            System.out.println("Mobile :" + c.getMobile());
                            System.out.println("-".repeat(50));
                        });
                    }
                    break;
                case 3:
                    System.out.println("Enter search string :");
                    String str = scanner.nextLine();
                    List<Contact> searchResults = dao.search(str);
                    if (searchResults.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        searchResults.forEach(c -> {
                            System.out.println("Id :" + c.getId());
                            System.out.println("Name :" + c.getName());
                            System.out.println("Email :" + c.getEmail());
                            System.out.println("Mobile :" + c.getMobile());
                            System.out.println("-".repeat(50));
                        });
                    }
                    break;
                case 4:
                    System.out.println("Enter contact id to update :");
                    String updateId = scanner.nextLine();
                    Contact existingContact = dao.selectById(updateId);
                    if (existingContact != null) {
                        System.out.println("Enter new name (press enter to keep existing):");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new email (press enter to keep existing):");
                        String newEmail = scanner.nextLine();
                        System.out.println("Enter new mobile (press enter to keep existing):");
                        String newMobile = scanner.nextLine();

                        if (!newName.trim().isEmpty()) existingContact.setName(newName);
                        if (!newEmail.trim().isEmpty()) existingContact.setEmail(newEmail);
                        if (!newMobile.trim().isEmpty()) existingContact.setMobile(newMobile);

                        dao.update(existingContact);
                        System.out.println("Contact updated successfully");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter contact id to delete :");
                    String deleteId = scanner.nextLine();
                    if (dao.delete(deleteId)) {
                        System.out.println("Contact deleted successfully");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                case 6:
                    flag = false;
                    System.out.println("Thank you for using Contact Book Manager");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
        scanner.close();
    }
}
