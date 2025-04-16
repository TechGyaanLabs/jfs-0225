package com.careerit.cj.cbook;

import java.util.List;

public interface ContactDao {

    Contact insertContact(Contact contact);
    List<Contact> selectAll();
    List<Contact> search(String str);
    Contact update(Contact contact);
    Contact selectById(String id);
    boolean delete(String id);
}
