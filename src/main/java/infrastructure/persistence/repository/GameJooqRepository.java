package infrastructure.persistence.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Action;
import domain.Player;
import infrastructure.jooq.generated.tables.records.GameRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jooq.DSLContext;
import org.jooq.False;
import org.jooq.Record;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Game;
import org.jooq.types.ULong;

import java.util.List;

import static infrastructure.jooq.generated.Tables.*;

@ApplicationScoped
public class GameJooqRepository implements IGameRepository {
    @Inject
    DSLContext dsl;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    @Transactional
    public Game insertNewGame(Game game) throws JsonProcessingException {
        // neue Spieler einfügen
        int i = 0;
        for(Player p : game.getPlayers()) {
            insertNewPlayer(p, i);
            i++;
        }

        // neues Game inserten
        GameRecord record = dsl.insertInto(GAME)
                .set(GAME.NUMBER_OF_PLAYERS, UInteger.valueOf(game.getPlayers().size()))
                .set(GAME.STATUS, game.getPhase().toString())
                .set(GAME.CURRENT_PLAYER_ID, ULong.valueOf(game.getCurrentPlayer().getId()))
                .set(GAME.ROUND, UInteger.valueOf(game.getRound()))
                .returning(GAME.ID).fetchOne();

        assert record != null;
        Long game_id = record.getId().longValue();
        game.setId(game_id);

        // Spieler aktuelles Game eintragen
        for (Player p : game.getPlayers()) {
            enterGame(game, p);
        }
        return game;
    }

    @Override
    public void insertNewPlayer(Player player, int player_index) throws JsonProcessingException {
         dsl.insertInto(PLAYER).set(PLAYER.ID, ULong.valueOf(player.getId()))
                 .set(PLAYER.POINTS, ULong.valueOf(player.getPoints()))
                 .set(PLAYER.PLAYER_INDEX, UInteger.valueOf(player_index))
                 .set(PLAYER.IS_VERIFIED, (byte) 0) //false
                 .set(PLAYER.PLAYFIELD, mapper.writeValueAsBytes(player.getPlayField()))
                 .set(PLAYER.NUMBER_OF_MOVES, ULong.valueOf(0))
                 .set(PLAYER.LAST_MOVE, (byte) (player.getLastMoveDone() ? 1 : 0))
                 .execute();
    }

    @Override
    public void updateGameSnapshot(Game game) throws JsonProcessingException {
        // create Snapshot-JSon
        dsl.update(GAME).set(GAME.SNAPSHOT, mapper.writeValueAsBytes(game)).where(GAME.ID.eq(ULong.valueOf(game.getId()))).execute();
    }

    @Override
    public void setGameStatus(Game game) {
        dsl.update(GAME)
                .set(GAME.STATUS, game.getPhase().toString())
                .where(GAME.ID.eq(ULong.valueOf(game.getId())))
                .execute();
    }

    @Override
    public void insertAction(Game game, Action action) throws JsonProcessingException {
        dsl.insertInto(ACTION)
                .set(ACTION.GAME_ID, ULong.valueOf(game.getId()))
                .set(ACTION.PLAYER_ID, ULong.valueOf(action.getPlayer().getId()))
                .set(ACTION.ACTION_ID, ULong.valueOf(game.getMoveCount()))
                .set(ACTION.FIELD_BEFORE, mapper.writeValueAsString(action.getPlayFieldBefore()))
                .set(ACTION.FIELD_AFTER, mapper.writeValueAsString(action.getPlayFieldAfter()))
                .set(ACTION.ACTION_TYPE, mapper.writeValueAsString(action.getActionType()))
                .execute();
    }

    @Override
    public void enterGame(Game game, Player player) {
    dsl.update(PLAYER)
            .set(PLAYER.CURRENT_GAME_ID, ULong.valueOf(game.getId()))
            .where(PLAYER.ID.eq(ULong.valueOf(player.getId())))
            .execute();
    }

    @Override
    public void setVerified(Player player) {
        dsl.update(PLAYER).set(PLAYER.IS_VERIFIED, (byte) 1).where(PLAYER.ID.eq(ULong.valueOf(player.getId()))).execute();
    }

    @Override
    public boolean isVerified(Player p) {
        return dsl.fetchExists(
                dsl.selectOne()
                        .from(PLAYER)
                        .where(PLAYER.ID.eq(ULong.valueOf(p.getId())))
                        .and(PLAYER.IS_VERIFIED.ne((byte) 0))
        );
    }

    @Override
    public List<Action> getAllActions(Game game) {
        return List.of();
    }

    @Override
    public Game getGame(Long player_id) {
        return null;
    }

    @Override
    public Player getPlayer(Long player_id) {
        return null;
    }

    @Override
    public List<Player> getPlayers(Long game_id) {
        return List.of();
    }

    @Override
    public Action getAction(Long action_id, Long game_id) {
        return null;
    }
}
