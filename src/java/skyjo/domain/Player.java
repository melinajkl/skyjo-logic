package skyjo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final Long id;
    @Setter
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
}
