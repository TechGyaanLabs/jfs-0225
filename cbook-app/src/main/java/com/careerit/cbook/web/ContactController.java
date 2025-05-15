package com.careerit.cbook.web;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.ContactService;
import com.careerit.cbook.util.FileType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contacts")
@Slf4j
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

    @GetMapping("/fileTypes")
    public List<String> getSupportedFileTypes() {
        return FileType.getFileTypes();
    }

    @GetMapping("/download")
    public void downloadContacts(HttpServletResponse response, @RequestParam("fileType") FileType fileType) {
        File file = contactService.downloadContacts(fileType);
        download(response, file);
    }

    private static void download(HttpServletResponse response, File file) {
        try {
            // Set the content type and headers
            response.setContentType("application/json");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            response.setContentLength((int) file.length());

            // Send the file to the client
            try(FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
                response.getOutputStream().flush();
            }
        } catch (IOException e) {
            log.error("Error while downloading file", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
