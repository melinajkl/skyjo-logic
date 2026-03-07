package skyjo.infrastructure.persistence.entities;

import skyjo.domain.Player;
import skyjo.domain.Card;
import skyjo.domain.ActionType;
import skyjo.domain.PlayField;

public class ActionEntity {
    private GameEntity game;
    private ActionType actionType;
    private PlayField playFieldBefore;
    private PlayField playFieldAfter;
    private boolean drawPile;
    private boolean newCard;
    private Card card;
    private Player player;
    private boolean lastMove;

    public ActionEntity(GameEntity game, ActionType actionType, PlayField playFieldBefore, PlayField playFieldAfter, boolean drawPile, boolean newCardInField, Card card, boolean lastMove) {
        this.game = game;
        this.actionType = actionType;
        this.playFieldBefore = playFieldBefore;
        this.playFieldAfter = playFieldAfter;
        this.drawPile = drawPile;
        this.newCard = newCardInField;
        this.card = card;
        this.lastMove = lastMove;
    }

    public GameEntity getGame() {
        return game;
    }
    public ActionType getActionType() {
        return actionType;
    }
    public PlayField getPlayFieldBefore() {
        return playFieldBefore;
    }
    public PlayField getPlayFieldAfter() {
        return playFieldAfter;
    }
    public boolean isDrawPile() {
        return drawPile;
    }
    public boolean isNewCard() {
        return newCard;
    }
    public Card getCard() {
        return card;
    }
    public Player getPlayer() {
        return player;
    }
    public boolean isLastMove() {
        return lastMove;
    }
}
