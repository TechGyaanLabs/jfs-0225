package com.careerit.cbook.util;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;

public final class ConvertUtil {
    private ConvertUtil() {}

    public static Contact dtoToDomain(ContactDto contact) {
        Contact domainContact = new Contact();
        domainContact.setId(contact.getId());
        domainContact.setName(contact.getName());
        domainContact.setEmail(contact.getEmail());
        domainContact.setMobile(contact.getMobile());
        domainContact.setCity(contact.getCity());
        domainContact.setDob(contact.getDob());
        return domainContact;
    }

    public static ContactDto domainToDto(Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setEmail(contact.getEmail());
        contactDto.setMobile(contact.getMobile());
        contactDto.setCity(contact.getCity());
        contactDto.setDob(contact.getDob());
        return contactDto;
    }
}
