package java.domain;

import java.util.List;

public class Game {
    private final Long id;
    private final List<Player> players;
    private int currentPlayerIndex;
    private TurnPhase phase;
    private final Pile drawPile;
    private final Pile discardPile;
    private int round;

    public Game (Long id, List<Player> players, Pile drawPile, Pile discardPile){
        this.id = id;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.phase = TurnPhase.MUST_DRAW_OR_TAKE_DISCARD;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.round = 1;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public void changeCurrentPlayer(){
        if (currentPlayerIndex == players.size() - 1){
            currentPlayerIndex = 0;
            round++;
        }
        else {
            currentPlayerIndex++;
        }
    }

    public Card drawFromDrawPile(){
        return drawPile.draw();
    }

    public Card drawFromDiscardPile(){
        return discardPile.draw();
    }

    public void setPhase(TurnPhase phase) {
        this.phase = phase;
    }
}