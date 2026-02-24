package infrastructure.persistence.repository;

import infrastructure.persistence.entities.ActionEntity;
import infrastructure.persistence.entities.GameEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.JsonObject;

import java.util.List;

public interface GameRepository {
    public void insertNewGame(String GameStatus, Long CurrentPlayerId);
    public PanacheEntityBase loadGame(Long gameId);
    public PanacheEntityBase loadSnapshot(Long gameId);
    public List<ActionEntity> loadActions(Long gameId);
    public void updateSnapshot(Long gameId, JsonObject jsonObject);
    public void appendAction(GameEntity game, String actorId, Long clientActionId, String type, String payloadJson);
}