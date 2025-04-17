package com.careerit.cj.cbook;

import com.careerit.cj.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDaoImpl implements ContactDao {

    private final DbUtil dbUtil;

    public ContactDaoImpl(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    private Contact mapToContact(ResultSet rs) throws SQLException {
        Contact contact = new Contact();
        contact.setId(UUID.fromString(rs.getString("id")));
        contact.setName(rs.getString("name"));
        contact.setEmail(rs.getString("email"));
        contact.setMobile(rs.getString("mobile"));
        return contact;
    }

    private <T> T executeQuery(String query, QueryExecutor<T> executor) {
        try (Connection con = dbUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            return executor.execute(pst);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query: " + query, e);
        }
    }

    @Override
    public Contact insertContact(Contact contact) {
        return executeQuery(ContactQueries.INSERT_CONTACT, pst -> {
            pst.setString(1, contact.getName());
            pst.setString(2, contact.getEmail());
            pst.setString(3, contact.getMobile());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    contact.setId(UUID.fromString(rs.getString("id")));
                }
                return contact;
            }
        });
    }

    @Override
    public List<Contact> selectAll() {
        return executeQuery(ContactQueries.SELECT_ALL_CONTACTS, pst -> {
            List<Contact> contacts = new ArrayList<>();
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    contacts.add(mapToContact(rs));
                }
            }
            return contacts;
        });
    }

    @Override
    public List<Contact> search(String str) {
        return executeQuery(ContactQueries.SEARCH_CONTACTS, pst -> {
            pst.setString(1, "%" + str + "%");
            List<Contact> contacts = new ArrayList<>();
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    contacts.add(mapToContact(rs));
                }
            }
            return contacts;
        });
    }

    @Override
    public Contact update(Contact contact) {
        return executeQuery(ContactQueries.UPDATE_CONTACT, pst -> {
            pst.setString(1, contact.getName());
            pst.setString(2, contact.getEmail());
            pst.setString(3, contact.getMobile());
            pst.setObject(4, contact.getId());
            pst.executeUpdate();
            return contact;
        });
    }

    @Override
    public Contact selectById(String id) {
        UUID contactId = UUID.fromString(id);
        return executeQuery(ContactQueries.SELECT_CONTACT_BY_ID, pst -> {
            pst.setObject(1, contactId);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next() ? mapToContact(rs) : null;
            }
        });
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @FunctionalInterface
    private interface QueryExecutor<T> {
        T execute(PreparedStatement pst) throws SQLException;
    }
}
