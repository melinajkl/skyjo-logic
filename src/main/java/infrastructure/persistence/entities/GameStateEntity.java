package infrastructure.persistence.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "game_state")
public class GameStateEntity extends PanacheEntityBase {

    @Id
    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Lob
    @Column(name = "state_json", nullable = false)
    private String stateJson;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private GameEntity game;

    protected GameStateEntity() {
        // JPA
    }

    public GameStateEntity(GameEntity game, String stateJson) {
        this.game = game;
        this.gameId = game.getId(); // may be null until persisted; MapsId will handle after persist
        this.stateJson = stateJson;
    }

    public Long getGameId() { return gameId; }
    public GameEntity getGame() { return game; }
    public String getStateJson() { return stateJson; }
    public void setStateJson(String stateJson) { this.stateJson = stateJson; }
}