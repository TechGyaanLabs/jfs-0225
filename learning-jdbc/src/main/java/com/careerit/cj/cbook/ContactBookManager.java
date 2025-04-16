package com.careerit.cj.cbook;

import com.careerit.cj.util.DbUtil;

public class ContactBookManager {

    public static void main(String[] args) {

        ContactDao obj = new ContactDaoImpl(DbUtil.getInstance());

        Contact contact = new Contact();
        contact.setName("Suresh");
        contact.setEmail("suresh@cj.com");
        contact.setMobile("9876543211");
        contact = obj.insertContact(contact);
        System.out.println("Contact inserted with id :"+contact.getId());
    }
}
