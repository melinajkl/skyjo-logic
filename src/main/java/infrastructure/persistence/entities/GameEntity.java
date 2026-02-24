package infrastructure.persistence.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "game")
public class GameEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "game_status", nullable = false, length = 32)
    private String gameStatus;

    @Column(name = "current_player_id")
    private Long currentPlayerId;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public GameEntity() {
        // JPA
    }

    public GameEntity(String gameStatus, Long currentPlayerId) {
        this.gameStatus = gameStatus;
        this.currentPlayerId = currentPlayerId;
    }

    public Long getId() { return id; }
    public String getGameStatus() { return gameStatus; }
    public void setGameStatus(String gameStatus) { this.gameStatus = gameStatus; }
    public Long getCurrentPlayerId() { return currentPlayerId; }
    public void setCurrentPlayerId(Long currentPlayerId) { this.currentPlayerId = currentPlayerId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}