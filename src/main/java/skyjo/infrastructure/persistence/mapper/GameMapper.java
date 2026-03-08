package skyjo.infrastructure.persistence.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.jooq.generated.tables.records.ActionRecord;
import skyjo.domain.*;

public class GameMapper implements IGameMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Action toDomain(ActionRecord a) {
        ActionType actionType = ActionType.valueOf(a.getActionType());
        PlayField before = toDomain(a.getFieldBefore());
        PlayField after = toDomain(a.getFieldAfter());
        boolean drawPile = a.getDrawPile();
        boolean newCardInField = a.getNewCard();
        Card card = toDomain(a.getCard());
        Player player = a.getPlayerId();
        boolean lastMove = after.countRevealedCard() == 12;
        Game game = a.getGameId();
        return new Action(actionType, before, after, drawPile, newCardInField, card, player, lastMove, game);
    }

    @Override
    public PlayField toDomain(String playfieldJson) {
        try {
            return objectMapper.readValue(playfieldJson, PlayField.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not deserialize PlayField JSON", e);
        }

    }

    @Override
    public Card toDomainCard(String cardJson) {
        return null;
    }
}
