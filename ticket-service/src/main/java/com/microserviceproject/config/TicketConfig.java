package com.microserviceproject.config;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableElasticsearchRepositories
@EnableJpaRepositories(basePackages = {"com.microserviceproject.repository"})
@ComponentScan("com.microserviceapp")

public class TicketConfig {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper() ;  }



}
