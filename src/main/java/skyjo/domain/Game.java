package skyjo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Game {
    @Setter
    private Long id;
    private final List<Player> players;
    private int currentPlayerIndex;
    private Status phase;
    private final Pile drawPile;
    private final Pile discardPile;
    private int round;
    private int moveCount = 0;

    public Game (Long id, List<Player> players, Pile drawPile, Pile discardPile){
        this.id = id;
        this.players = players;
        this.currentPlayerIndex = 0;
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
        moveCount++;
    }

    public Card drawFromDrawPile(){
        return drawPile.draw();
    }

    public Card drawFromDiscardPile(){
        return discardPile.draw();
    }

    public void setPhase(Status phase) {
        this.phase = phase;
    }
}