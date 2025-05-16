package com.careerit.cbook.web;

import com.careerit.cbook.dto.CountryInfoDto;
import com.careerit.cbook.service.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryInfoController {

    @Autowired
    private CountryInfoService countryInfoService;

    @GetMapping("/load-latest-data")
    public List<CountryInfoDto> loadLatestData(@RequestParam(value = "force",defaultValue = "false") boolean force) {
       return countryInfoService.loadLatestData(force);
    }
}
