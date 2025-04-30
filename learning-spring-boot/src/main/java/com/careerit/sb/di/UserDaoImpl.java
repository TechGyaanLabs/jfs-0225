package com.careerit.sb.di;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

        private static final List<String> users = List.of("John", "Kiran", "Ravi", "Rajesh");

        public List<String> getAllUsers() {
            return users;
        }
}
