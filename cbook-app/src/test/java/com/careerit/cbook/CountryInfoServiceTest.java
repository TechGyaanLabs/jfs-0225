package com.careerit.cbook;

import com.careerit.cbook.dto.CountryInfoDto;
import com.careerit.cbook.service.CountryInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CountryInfoServiceTest {
    @Autowired
   private CountryInfoService countryInfoService;

    @Test
   public void testGetCountryInfo() {
       List<CountryInfoDto> list =  countryInfoService.loadLatestData(true);
        System.out.println(list);
   }
}
