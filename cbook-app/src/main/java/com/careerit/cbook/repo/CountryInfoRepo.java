package com.careerit.cbook.repo;

import com.careerit.cbook.domain.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryInfoRepo extends JpaRepository<CountryInfo, UUID> {

}
