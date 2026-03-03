package infrastructure.persistence.entities;

import java.util.List;

public class GameEntity extends PileCardPlayfieldEntity {

    private final List<Object> players;

    public GameEntity(Long id,
                      List<Object> players,
                      int currentPlayerIndex,
                      Object drawPile,
                      Object discardPile,
                      int round) {
        super(id, currentPlayerIndex, drawPile, discardPile, round);
        this.players = players;
    }

    public List<Object> getPlayers() {
        return players;
    }
}