package skyjo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import skyjo.application.GameUpsetter;
import skyjo.domain.Game;

import java.util.List;

@Path("/setUpGame")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SetUpPoint {

    @Inject
    GameUpsetter gameUpsetter;


    @POST
    public Game setUpGame(List<Long> ids) throws JsonProcessingException {
        return gameUpsetter.setUpGame(ids);
    }
}