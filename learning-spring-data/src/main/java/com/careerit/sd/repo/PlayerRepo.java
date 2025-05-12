package com.careerit.sd.repo;

import com.careerit.sd.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlayerRepo extends JpaRepository<Player, UUID> {
    List<Player> findByTeam(String team);
    List<Player> findByCountry(String country);
}
