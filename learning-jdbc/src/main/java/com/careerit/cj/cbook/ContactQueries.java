package com.careerit.cj.cbook;

public class ContactQueries {
    public static final String INSERT_CONTACT = """
            insert into contact
                (name, email, mobile)
                values (?,?,?) RETURNING id
            """;

    public static final String SELECT_ALL_CONTACTS = """
            select id, name, email, mobile
            from contact where deleted = false
            order by name 
            """;

    public static final String SEARCH_CONTACTS = """
            select id, name, email, mobile
            from contact where deleted = false and name ilike ?
            order by name 
            """;

    public static final String UPDATE_CONTACT = """
            update contact
            set name = ?, email = ?, mobile = ?
            where id = ?
            """;

    public static final String DELETE_CONTACT = """
            update contact
            set deleted = true
            where id = ?
            """;

    public static final String SELECT_CONTACT_BY_ID = """
            select id, name, email, mobile
            from contact where id = ? and deleted = false
            """;


}
