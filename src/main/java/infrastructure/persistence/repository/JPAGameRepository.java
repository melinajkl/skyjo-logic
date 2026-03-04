package java.infrastructure.persistence.repository;

import java.infrastructure.persistence.entities.ActionEntity;
import java.infrastructure.persistence.entities.GameEntity;
import java.infrastructure.persistence.entities.GameStateEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.JsonObject;

import java.util.List;

@ApplicationScoped
public class JPAGameRepository implements GameRepository{
    @Override
    public void insertNewGame(String GameStatus, Long CurrentPlayerId) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.persist();
    }

    @Override
    public GameEntity loadGame(Long gameId) {
        return GameEntity.findById(gameId);
    }

    @Override
    public GameStateEntity loadSnapshot(Long gameId) {
        return GameStateEntity.findById(gameId);
    }

    @Override
    public List<ActionEntity> loadActions(Long gameId) {
        return ActionEntity.find("game.id = ?1 ORDER BY actionId ASC", gameId).list();
    }

    @Override
    public void updateSnapshot(Long gameId, JsonObject jsonObject) {
        GameEntity game = GameEntity.findById(gameId);
        GameStateEntity gameStateEntity = new GameStateEntity(game, jsonObject.toString());
        gameStateEntity.persist();
    }

    @Override
    public void appendAction(GameEntity game, String actorId, Long clientActionId, String type, String payloadJson) {
        ActionEntity a = new ActionEntity(game, actorId, clientActionId, type, payloadJson);
        a.persist();
    }
}
