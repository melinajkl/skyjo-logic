package java.domain;

public class Card {
    private final int value;
    private boolean revealed = false;

    public Card(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void reveal(){
        revealed = true;
    }
}