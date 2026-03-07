package skyjo.infrastructure.persistence.mapper;

import skyjo.domain.Card;
import skyjo.domain.PlayField;

public interface IGameMapper {
    public String PlayFieldToJson(PlayField playField);
    public String CardToJson(Card card);
}
