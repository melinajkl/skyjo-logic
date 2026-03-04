package java.infrastructure.persistence.mapper;

import java.domain.Action;
import java.domain.Game;
import java.infrastructure.persistence.entities.ActionEntity;
import java.infrastructure.persistence.entities.GameEntity;
import java.infrastructure.persistence.entities.GameStateEntity;

public interface DomainEntityMapper {
    public GameEntity toGameEntity(Game game);
    public GameStateEntity toGameStateEntity(GameStateEntity gameStateEntity);
    public ActionEntity toActionEntity(Action action);
}
