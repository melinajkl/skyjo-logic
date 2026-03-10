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

        return true;
    }

    private static boolean validateDiscardPile(Action action){
    return true;
    }
}
