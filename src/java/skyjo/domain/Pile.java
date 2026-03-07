package skyjo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
public class Pile {
    @Setter
    private Stack<Card> stack;
    private final boolean revealed;

    public Pile (Stack<Card> stack, boolean revealed){
        this.stack = stack;
        this.revealed = revealed;
    }

    public Card draw(){
        return stack.pop();
    }

    public Card showFristCard(){
        if (revealed){
            return stack.peek();
        }
        else {
            throw new IllegalMoveException("Cannot look at unrevealed pile");
        }
    }

    public void layCard(Card card){
        if (revealed) {
            stack.push(card);
        }
        else {
            throw new IllegalMoveException("Cannot lay card on unrevealed pile");
        }
    }
}
