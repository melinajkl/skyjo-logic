package infrastructure.persistence.mapper;

import domain.Card;
import domain.PlayField;

public interface IGameMapper {
    public String PlayFieldToJson(PlayField playField);
    public String CardToJson(Card card);
}
