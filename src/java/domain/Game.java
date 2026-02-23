package java.domain;

import java.util.List;

public class Game {
    private Long id;
    private List<Player> players;
    private int currentPlayerIndex;
    private TurnPhase phase;
    private Pile drawPile;
    private Pile discardPile;
    private int round;
}
