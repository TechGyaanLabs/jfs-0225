package com.careerit.cj.cbook;

public class ContactQueries {
    public static final String INSERT_CONTACT = """
            insert into contact
                (name, email, mobile)
                values (?,?,?) RETURNING id
            """;
}
