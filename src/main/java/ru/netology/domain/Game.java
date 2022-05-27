package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Game {

    private Collection<Player> players = new ArrayList<>();


    //метод регистрации игрока
    public void register(Player player) {
        this.players.add(player);
    }

    //поиск игрока
    private int findPlayer(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                int findPlayer = player.getStrength();
                return findPlayer;
            }
        }
        return 0;
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        int findPlayer1 = findPlayer(playerName1);
        int findPlayer2 = findPlayer(playerName2);
        if (findPlayer1 == 0) {
            throw new NotRegisteredException("Игрок под номером 1 не зарегистрирован.");
        }
        if (findPlayer2 == 0) {
            throw new NotRegisteredException("Игрок под номером 2 не зарегистрирован.");
        }
        if (findPlayer1 > findPlayer2) {
            return 1;
        }
        if (findPlayer1 < findPlayer2) {
            return 2;
        }
        return 0;

    }


}
