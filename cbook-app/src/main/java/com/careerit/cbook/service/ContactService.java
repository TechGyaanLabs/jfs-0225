package com.careerit.cbook.service;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.util.FileType;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    ContactDto addContact(ContactDto contactDto);
    ContactDto updateContact(ContactDto contactDto);
    ContactDto getContactById(UUID id);
    String deleteContact(UUID id);
    List<ContactDto> getAllContacts();
    List<ContactDto> search(String str);
    List<ContactDto> addAll(List<ContactDto> contactDtos);
    void downloadContacts(FileType fileType);

}
