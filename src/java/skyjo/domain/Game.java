package skyjo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Getter
public class Game {
    @Setter
    private Long id;
    private final List<Player> players;
    private int currentPlayerIndex;
    @Setter
    private Status phase;
    private final Pile drawPile;
    private final Pile discardPile;
    @Setter
    private int round;
    private int moveCounter;

    public Game (List<Player> players, Pile drawPile, Pile discardPile){
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
        }
        else {
            currentPlayerIndex++;
        }
        moveCounter++;
    }

    public Card drawFromDrawPile(){
        return drawPile.draw();
    }

    public Card drawFromDiscardPile(){
        return discardPile.draw();
    }

    public void reshufflePiles(){
        Card topCard = discardPile.draw();
        Collections.shuffle(discardPile.getStack());
        drawPile.setStack(discardPile.getStack());
        discardPile.setStack(new Stack<>());
        discardPile.layCard(topCard);
    }
}
