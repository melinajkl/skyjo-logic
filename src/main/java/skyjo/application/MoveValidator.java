package skyjo.application;

import skyjo.domain.Action;
import skyjo.domain.ActionType;
import java.util.Objects;

public class MoveValidator {
    public static boolean validateMove(Action action){
        ActionType actionType = action.getActionType();

        return switch (actionType) {
            case SETUP -> validateSetup(action);
            case DRAW_FROM_DRAW_PILE -> validateDrawPile(action);
            case DRAW_FROM_DISCARD_PILE -> validateDiscardPile(action);
        };
    }

    private static boolean validateSetup(Action action){
        // Warten auf GameUpsetter
        return true;
    }

    private static boolean validateDrawPile(Action action){
        // Validate if player is allowed to move
        if (!Objects.equals(action.getPlayer().getId(), action.getGame().getCurrentPlayer().getId())) return false;

        // Check if Playfield is correct
        if (!Objects.equals(action.getPlayer().getPlayField(), action.getPlayFieldBefore())) return false;

        // Check if Playfield after is correct?

        // Check if drawPile is correct
        if (!action.isDrawPile()) return false;

        // Check if drawn Card is from Draw Pile
        if (!Objects.equals(action.getCard(), action.getGame().getDrawPile().getStack().peek())) return false;

        // Check if lastMove was played
        if (action.getPlayer().getLastMoveDone()) return false;

        return true;
    }

    private static boolean validateDiscardPile(Action action){
        // Validate if player is allowed to move
        if (!Objects.equals(action.getPlayer().getId(), action.getGame().getCurrentPlayer().getId())) return false;

        // Check if Playfield is correct
        if (!Objects.equals(action.getPlayer().getPlayField(), action.getPlayFieldBefore())) return false;

        // Check if Playfield after is correct?

        // Check if drawPile is correct
        if (action.isDrawPile()) return false;

        // Check if there is a new Card in Field
        if (!action.isNewCardInField()) return false;

        // Check if drawn Card is from Draw Pile
        if (!Objects.equals(action.getCard(), action.getGame().getDiscardPile().getStack().peek())) return false;

        // Check if lastMove was played
        if (action.getPlayer().getLastMoveDone()) return false;


        return true;
    }
}
