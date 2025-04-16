package com.careerit.cj.cbook;

import java.util.List;

public interface ContactService {

    Contact addContact(Contact contact);
    List<Contact> getAll();
    List<Contact> search(String str);
    Contact update(Contact contact);
    Contact getById(String id);
    boolean delete(String id);
}
