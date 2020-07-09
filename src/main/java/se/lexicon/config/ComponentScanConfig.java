package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class ComponentScanConfig {

    @Bean
    Scanner getScanner(){
        return new Scanner(System.in);
    }

}
