package domain;

import lombok.Getter;

public class Card {
    private final int value;
    private boolean revealed = false;

    public Card(int value) {
        this.value = value;
    }

    public int getValue(boolean admin){
        if (admin) return value;
        if (revealed) {
            return value;
        }
        else {
            throw new IllegalMoveException("Cant look at unrevealed card");
        }
    }

    public void reveal(){
        revealed = true;
    }

    public boolean getRevealed() {
        return revealed;
    }
}