package com.example.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole {

    public void up() {
        System.out.println("SuperConotra up");
    }

    public void down() {
        System.out.println("SuperConotra down");
    }

    public void left() {
        System.out.println("SuperConotra left");
    }

    public void right() {
        System.out.println("SuperConotra right");
    }
    
}
