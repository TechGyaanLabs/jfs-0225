package com.careerit.sb.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<String> getAllUsers();
}
