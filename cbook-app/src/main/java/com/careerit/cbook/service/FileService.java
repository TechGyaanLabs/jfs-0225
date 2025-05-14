package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;

import java.io.File;
import java.util.List;

public interface FileService {
    File getFile(List<Contact> contacts);
}
