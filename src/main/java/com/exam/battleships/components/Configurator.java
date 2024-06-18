package com.exam.battleships.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurator {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
