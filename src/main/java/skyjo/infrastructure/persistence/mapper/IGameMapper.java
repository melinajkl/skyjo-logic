package skyjo.infrastructure.persistence.mapper;

import infrastructure.jooq.generated.tables.records.ActionRecord;
import skyjo.domain.Action;
import skyjo.domain.Card;
import skyjo.domain.PlayField;

public interface IGameMapper {
    public Action toDomain(ActionRecord a);
    public PlayField toDomain(String playfieldJSon);
    public Card toDomainCard(String cardJson);
}
