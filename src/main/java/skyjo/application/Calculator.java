package skyjo.application;

import java.skyjo.domain.Game;
import java.skyjo.domain.PlayField;
import java.skyjo.domain.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    // Map<PlayerID, Points>
    public static Map<Long, Long> calculatePointsFromRound(Game game){
        List<Player> players = game.getPlayers();
        HashMap<Long, Long> points = new HashMap<>();
        for (Player player : players){
            PlayField playField = player.getPlayField();
            points.put(player.getId(), playField.calculateSum());
        }

        return points;
    }

    // Map<PlayerID, Points>
    public static Map<Long, Long> calculateEndPoints(Game game){
        List<Player> players = game.getPlayers();
        HashMap<Long, Long> points = new HashMap<>();
        for (Player player : players){
            points.put(player.getId(), player.getPoints());
        }

        return points;
    }
}
