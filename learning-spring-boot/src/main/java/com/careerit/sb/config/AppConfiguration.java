package com.careerit.sb.config;

import com.careerit.sb.domain.Greetings;
import com.careerit.sb.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Greetings greetings(){
        Greetings greetings = new Greetings();
        greetings.setMessage("Hello World");
        return greetings;
    }

}
