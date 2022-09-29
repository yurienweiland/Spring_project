package com.ilionx.carapp.api;


import com.ilionx.carapp.api.Coureur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public Coureur maxVerstappen() {

        Coureur max = new Coureur();
        max.setName("Max Verstappen");

        return max;
    }

    @Bean
    public Coureur lewisHamilton() {
        Coureur lewis = new Coureur();
        lewis.setName("Lewis Hamilton");

        return lewis;
    }
}