package java.skyjo.application;

import java.skyjo.domain.Action;
import java.skyjo.domain.ActionType;
import java.util.Objects;

public class MoveValidator {
    public static boolean validateMove(Action action){
        ActionType actionType = action.getActionType();

        return switch (actionType) {
            case SETUP -> validateSetup();
            case DRAW_FROM_DRAW_PILE -> validateDrawPile();
            case DRAW_FROM_DISCARD_PILE -> validateDiscardPile();
        };
    }

    private static boolean validateSetup(Action action){
        // Warten auf GameUpsetter
        return true;
    }

    private static boolean validateDrawPile(Action action){
        // Validate if player is allowed to move
        if (!Objects.equals(action.getPlayer().getId(), action.getGame().getCurrentPlayer().getId())) return false;

        
    }

    private static boolean validateDiscardPile(Action action){

    }
}
