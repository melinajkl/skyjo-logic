package java.infrastructure.persistence.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "action",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_action_game_client", columnNames = {"game_id", "client_action_id"})
        }
)
public class ActionEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id", nullable = false, updatable = false)
    private Long actionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "game_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_action_game")
    )
    private GameEntity game;

    @Column(name = "actor_id", nullable = false, length = 48)
    private String actorId;

    @Column(name = "client_action_id", nullable = false)
    private Long clientActionId;

    @Column(name = "type", nullable = false, length = 64)
    private String type;

    @Lob
    @Column(name = "payload_json")
    private String payloadJson;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    protected ActionEntity() {
        // JPA
    }

    public ActionEntity(GameEntity game, String actorId, Long clientActionId, String type, String payloadJson) {
        this.game = game;
        this.actorId = actorId;
        this.clientActionId = clientActionId;
        this.type = type;
        this.payloadJson = payloadJson;
    }

    public Long getActionId() { return actionId; }
    public GameEntity getGame() { return game; }
    public String getActorId() { return actorId; }
    public void setActorId(String actorId) { this.actorId = actorId; }
    public Long getClientActionId() { return clientActionId; }
    public void setClientActionId(Long clientActionId) { this.clientActionId = clientActionId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getPayloadJson() { return payloadJson; }
    public void setPayloadJson(String payloadJson) { this.payloadJson = payloadJson; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}