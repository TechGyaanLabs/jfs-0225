package com.careerit.cj.jdbc;

import com.careerit.cj.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerService {


    public List<Player> getPlayers(){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select id,name,role,team,country,amount from player";
        List<Player> players = new ArrayList<>();
        try{
            con = DbUtil.getInstance().getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                UUID id = UUID.fromString(rs.getString("id"));
                String name = rs.getString("name");
                String role = rs.getString("role");
                String team = rs.getString("team");
                String country = rs.getString("country");
                double amount = rs.getDouble("amount");
                Player player = Player.builder()
                        .id(id)
                        .name(name)
                        .role(role)
                        .team(team)
                        .country(country)
                        .amount(amount)
                        .build();
                players.add(player);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.getInstance().close(rs, st, con);
        }
        return players;
    }

    public List<Player> topPaidPlayersFromEveryTeam(){
        //TODO
        return null;
    }

    public List<TeamAmountDto> getAmountSpentByEveryTeam(){
        //TODO
        return null;
    }
}
