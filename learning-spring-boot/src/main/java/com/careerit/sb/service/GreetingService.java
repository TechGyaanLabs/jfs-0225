package com.careerit.sb.service;

import com.careerit.sb.domain.Greetings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class GreetingService {
    @Autowired
    private Greetings greetings;

    public void showGreetings(){
        System.out.println(greetings.getMessage());
    }
}
