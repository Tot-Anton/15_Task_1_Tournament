package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    //победа первого игрока
    @Test
    void theVictoryOfTheFirstPlayer() {
        Player player1 = new Player(1, "Разрушитель", 150);
        Player player2 = new Player(2, "Созидатель", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Разрушитель", "Созидатель");
        assertEquals(expected, actual);
    }

    //победа второго игрока
    @Test
    void theVictoryOfTheSecondPlayer() {
        Player player1 = new Player(1, "Разрушитель", 50);
        Player player2 = new Player(2, "Созидатель", 150);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Разрушитель", "Созидатель");
        assertEquals(expected, actual);
    }


    //турнир равных игроков
    @Test
    void tournamentOfEqualPlayers() {
        Player player1 = new Player(1, "Разрушитель", 50);
        Player player2 = new Player(2, "Созидатель", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Разрушитель", "Созидатель");
        assertEquals(expected, actual);
    }

    //один из игроков не зарегистрирован
    @Test
    void playerWithoutRegistration1() {
        Player player1 = new Player(1, "Разрушитель", 50);
        Player player2 = new Player(2, "Созидатель", 150);

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Разрушитель", "Созидатель");
        });
    }

    //один из игроков не зарегистрирован
    @Test
    void playerWithoutRegistration2() {
        Player player1 = new Player(1, "Разрушитель", 50);
        Player player2 = new Player(2, "Созидатель", 150);

        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Разрушитель", "Созидатель");
        });
    }

    //незарегистрированные оба
    @Test
    void unregisteredBoth() {
        Player player1 = new Player(1, "Разрушитель", 50);
        Player player2 = new Player(2, "Созидатель", 150);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Разрушитель", "Созидатель");
        });
    }


}