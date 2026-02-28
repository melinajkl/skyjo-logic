package java.domain;

public class Action {
    private ActionType actionType;
    private PlayField playFieldBefore;
    private PlayField playFieldAfter;
    private boolean drawPile;
    private boolean newCardInField;
    private Card card;
    private Player player;
    private boolean lastMove;

    public Action (ActionType actionType, PlayField playFieldBefore, PlayField playFieldAfter, boolean drawPile, boolean newCardInField, Card card, Player player, boolean lastMove){
        this.actionType = actionType;
        this.playFieldBefore = playFieldBefore;
        this.playFieldAfter = playFieldAfter;
        this.drawPile = drawPile;
        this.newCardInField = newCardInField;
        this.card = card;
        this.player = player;
        this.lastMove = lastMove;
    }
}
