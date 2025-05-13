package com.careerit.cbook.repo;

import com.careerit.cbook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {

    @Query("select c from Contact c where c.mobile = ?1 and c.deleted = false")
    Contact findByMobile(String mobile);

    @Query("select c from Contact c where c.deleted = false")
    List<Contact> findAll();

    @Query("select c from Contact c where lower(c.name) like ?1 or lower(c.email) like ?1 or c.mobile like ?1  and c.deleted = false")
    List<Contact> search(String str);
}
