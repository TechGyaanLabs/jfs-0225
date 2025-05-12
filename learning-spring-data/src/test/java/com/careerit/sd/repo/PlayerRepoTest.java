package com.careerit.sd.repo;

import com.careerit.sd.domain.Player;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PlayerRepoTest {

    private static List<Player> players;
    private  Player player;

    @Autowired
    private PlayerRepo playerRepo;

    @BeforeAll
    public static void init(){
        players = new ArrayList<>();
        Player player1 = new Player();
        player1.setName("Virat");
        player1.setRole("Batsman");
        player1.setTeam("RCB");
        player1.setCountry("India");
        player1.setAmount(1000000);
        players.add(player1);
        Player player2 = new Player();
        player2.setName("Rohit");
        player2.setRole("Batsman");
        player2.setTeam("RCB");
        player2.setCountry("India");
        player2.setAmount(1000000);
        players.add(player2);


    }

    @AfterAll
    public static void destroy(){
        players = null;
    }

    @BeforeEach
    public void beforeEach(){
        playerRepo.deleteAll();
        player = new Player();
        player.setName("Rishabh");
        player.setRole("Batsman");
        player.setTeam("RCB");
        player.setCountry("India");
        player.setAmount(2700000);
    }

    @AfterEach
    public void afterEach(){
        playerRepo.deleteAll();
    }

    @Test
    public void addPlayer(){
       Player savedPlayer = playerRepo.save(player);
       Assertions.assertNotNull(savedPlayer);
       Assertions.assertNotNull(savedPlayer.getId());
       Assertions.assertEquals(player.getName(), savedPlayer.getName());
    }


} 