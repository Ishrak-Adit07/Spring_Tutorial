package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.Pacman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.example.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            GamingConsole pacmanGame = context.getBean("marioGame", GamingConsole.class);
            context.getBean(GameRunner.class).setGame(pacmanGame);
            context.getBean(GameRunner.class).run();

        }

    }
}
