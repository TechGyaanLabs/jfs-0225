package com.careerit.cj.cbook;

import com.careerit.cj.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ContactDaoImpl implements ContactDao{



    private DbUtil dbUtil;

    public ContactDaoImpl(DbUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    @Override
    public Contact insertContact(Contact contact) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            con = dbUtil.getConnection();
            pst = con.prepareStatement(ContactQueries.INSERT_CONTACT);
            pst.setString(1, contact.getName());
            pst.setString(2, contact.getEmail());
            pst.setString(3, contact.getMobile());
            rs = pst.executeQuery();
            if(rs.next()){
                String returnId = rs.getString("id");
                contact.setId(UUID.fromString(returnId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbUtil.close(rs, pst, con);
        }
        return contact;
    }

    @Override
    public List<Contact> selectAll() {
        return List.of();
    }

    @Override
    public List<Contact> search(String str) {
        return List.of();
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact selectById(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
