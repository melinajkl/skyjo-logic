package java.domain;

import java.util.List;

public class GameState {
    private List<PlayerState> players;
    private int currentPlayerIndex;
    private TurnPhase phase;
    private Pile drawPile;
    private Pile discardPile;
    private int round;
}
