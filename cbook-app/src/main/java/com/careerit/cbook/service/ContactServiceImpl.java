package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.repo.ContactRepo;
import com.careerit.cbook.util.ConvertUtil;
import com.careerit.cbook.util.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public ContactDto addContact(ContactDto contactDto) {
        Assert.notNull(contactDto, "ContactDto should not be null");
        Assert.hasText(contactDto.getName(), "Name should not be empty");
        Assert.hasText(contactDto.getMobile(), "Mobile should not be empty");

        // Check if the contact already exists
        Contact existingContact = contactRepo.findByMobile(contactDto.getMobile());
        if (existingContact != null) {
            throw new ContactAlreadyExistsException("Contact with this mobile number already exists");
        }
        // Convert ContactDto to Contact entity
        Contact contact = ConvertUtil.dtoToDomain(contactDto);
        // Save the contact entity to the database
        contact.setDeleted(false);
        contactRepo.save(contact);
        contactDto = ConvertUtil.domainToDto(contact);
        log.info("Contact is added with id {} and name {}", contactDto.getId(), contactDto.getName());
        return contactDto;
    }

    @Override
    public ContactDto updateContact(ContactDto contactDto) {
        Assert.notNull(contactDto, "ContactDto should not be null");
        Assert.hasText(contactDto.getId().toString(), "Id should not be empty");
        Assert.hasText(contactDto.getName(), "Name should not be empty");
        Assert.hasText(contactDto.getMobile(), "Mobile should not be empty");

        // Check if the contact exists
        Optional<Contact> contactOptional = contactRepo.findById(contactDto.getId());
        if (contactOptional.isPresent()) {
            // is mobile number already exists
            Contact existingContact = contactRepo.findByMobile(contactDto.getMobile());
            if (existingContact != null && !existingContact.getId().equals(contactDto.getId())) {
                throw new ContactAlreadyExistsException("Contact with this mobile number already exists");
            }
            Contact contact = contactOptional.get();
            contact.setName(contactDto.getName());
            contact.setEmail(contactDto.getEmail());
            contact.setMobile(contactDto.getMobile());
            contact.setCity(contactDto.getCity());
            contact.setDob(contactDto.getDob());
            contactRepo.save(contact);
            log.info("Contact is updated with id {} and name {}", contactDto.getId(), contactDto.getName());
            return ConvertUtil.domainToDto(contact);
        } else {
            log.error("Contact is not updated, Contact not found with id {}", contactDto.getId());
            throw new ContactNotFoundException("Contact not found with id " + contactDto.getId());
        }
    }

    @Override
    public ContactDto getContactById(UUID id) {
        Optional<Contact> contactOptional = contactRepo.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            ContactDto contactDto = ConvertUtil.domainToDto(contact);
            log.info("Contact is found with id {} and name {}", contactDto.getId(), contactDto.getName());
            return contactDto;
        } else {
            log.error("Contact not found with id {}", id);
            throw new ContactNotFoundException("Contact not found with id " + id);
        }
    }

    @Override
    public String deleteContact(UUID id) {

        Optional<Contact> contactOptional = contactRepo.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setDeleted(true);
            contactRepo.save(contact);
            log.info("Contact is deleted with id {}", id);
            return "Contact deleted successfully";
        } else {
            log.error("Contact is deleted, Contact not found with id {}", id);
            throw new ContactNotFoundException("Contact not found with id " + id);
        }

    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepo.findAll();
        List<ContactDto> contactDtos =  contacts.stream()
                .map(ConvertUtil::domainToDto)
                .toList();
        log.info("Total {} contacts are found", contactDtos.size());
        return contactDtos;
    }

    @Override
    public List<ContactDto> search(String str) {
        List<Contact> contacts = contactRepo.search(str.toLowerCase());
        List<ContactDto> contactDtos =  contacts.stream()
                .map(ConvertUtil::domainToDto)
                .toList();
        log.info("Total {} contacts are found for search string {}", contactDtos.size(), str);
        return contactDtos;
    }

    @Override
    public List<ContactDto> addAll(List<ContactDto> contactDtos) {
        List<ContactDto> addedContacts = new ArrayList<>();
        List<ContactDto> contactWithError = new ArrayList<>();
        for (ContactDto contactDto : contactDtos) {
            try {
                ContactDto addedContact = addContact(contactDto);
                addedContacts.add(addedContact);
            } catch (ContactAlreadyExistsException e) {
                log.error("Contact with mobile {} already exists", contactDto.getMobile());
                contactWithError.add(contactDto);
            }
        }
        log.info("Total {} contacts are added", addedContacts.size());
        if(!CollectionUtils.isEmpty(contactWithError)){
            log.info("Total {} contacts are not added due to duplicate mobile number", contactWithError.size());
            List<String> mobileNumbers = contactWithError.stream()
                    .map(ContactDto::getMobile)
                    .toList();
            log.info("Duplicate mobile numbers are {}", mobileNumbers);
        }
        return addedContacts;
    }

    @Override
    public File downloadContacts(FileType fileType) {
        FileService fileService = FileServiceFactory.getFileService(fileType);
        List<Contact> contacts = contactRepo.findAll();
        File file = fileService.getFile(contacts);
        log.info("File is downloaded with name {}", file.getName());
        return file;
    }


}
