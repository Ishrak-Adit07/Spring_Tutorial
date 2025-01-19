package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//class GamingConfiguration {
//
//    @Bean
//    public GamingConsole game() {
//        var game = new Pacman();
//        return game;
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
//
//}

@Configuration
@ComponentScan("com.example.learnspringframework.game")
public class App03GamingSpringBeans {

//    @Bean
//    public GamingConsole game() {
//        var game = new Pacman();
//        return game;
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {

            context.getBean(GamingConsole.class).left();
            context.getBean(GameRunner.class).run();

        }

//        var marioGame = new MarioGame();
//        var superContraGame = new SuperContraGame();
//        var pacmanGame = new Pacman();

//        var marioGameRunner = new GameRunner(marioGame);
//        var superGameRunner = new GameRunner(superContraGame);
//        var pacmanGameRunner = new GameRunner(pacmanGame);

//        marioGameRunner.run();
//        superGameRunner.run();
//        pacmanGameRunner.run();

    }

}
