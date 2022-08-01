package com.dibimbing.dibimbing.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TestBeans {
    @Bean // Objek
    public String appSaya(){
        return "aplikasi pertama saya";
    }
}
