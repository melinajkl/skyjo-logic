package infrastructure.persistence.entities;

import java.util.List;

// database entity which can be used to map to Game
public class PileCardPlayfieldEntity {
    protected Long id;
    private int currentPlayerIndex;
    private Object drawPile;
    private Object discardPile;
    private int round;

    public PileCardPlayfieldEntity(Long id, int currentPlayerIndex, Object drawPile, Object discardPile, int round) {
        this.id = id;
        this.currentPlayerIndex = currentPlayerIndex;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.round = round;
    }

    public Long getId() {
        return id;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Object getDrawPile() {
        return drawPile;
    }

    public Object getDiscardPile() {
        return discardPile;
    }

    public int getRound() {
        return round;
    }
}
