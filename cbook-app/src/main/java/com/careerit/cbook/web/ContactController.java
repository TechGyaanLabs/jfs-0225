package com.careerit.cbook.web;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public List<ContactDto> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/search")
    public List<ContactDto> search(@RequestParam("str") String str) {
        return contactService.search(str);
    }

    @PostMapping
    public ContactDto addContact(@RequestBody ContactDto contactDto) {
        return contactService.addContact(contactDto);
    }

    @PutMapping
    public ContactDto updateContact(@RequestBody ContactDto contactDto) {
        return contactService.updateContact(contactDto);
    }

    @GetMapping("/{id}")
    public ContactDto getContactById(@PathVariable("id") UUID id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable("id") UUID id) {
        return contactService.deleteContact(id);
    }
}
