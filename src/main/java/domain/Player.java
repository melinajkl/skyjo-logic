package domain;

import lombok.Getter;

@Getter
public class Player {
    private final Long id;
    private PlayField playField;
    private Long points;
    private boolean lastMoveDone;

    public Player (Long id, PlayField playField){
        this.id = id;
        this.playField = playField;
        this.points = 0L;
        this.lastMoveDone = false;
    }

    public void addPoints (Long points){
        this.points = this.points + points;
    }

    public void playLastMove (){
        this.lastMoveDone = true;
    }

    public boolean getLastMoveDone (){
        return this.lastMoveDone;
    }

    public PlayField getPlayField() {
        return playField;
    }

    public void setPlayField(PlayField playField) {
        this.playField = playField;
    }


}