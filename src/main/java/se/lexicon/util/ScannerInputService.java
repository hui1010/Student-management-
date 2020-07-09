package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {
    private Scanner scanner;

    @Autowired
    private ScannerInputService(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine().trim();
    }

    @Override
    public int getInt() {
        boolean invalid = true;
        int number = 0;
        while(invalid){
            try{
                number = Integer.parseInt(getString());//nextInt() can trigger bugs, always use String
                invalid = false;
            }catch(NumberFormatException e) {
                System.out.println("invalid input, could not be parsed to int");
            }
        }
        return number;
    }
}
