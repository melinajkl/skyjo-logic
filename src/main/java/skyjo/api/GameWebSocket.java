package skyjo.api;

import com.google.errorprone.annotations.FormatString;
import io.quarkus.websockets.next.OnClose;
import io.quarkus.websockets.next.OnError;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.quarkus.websockets.next.WebSocketConnection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import skyjo.api.wsconnector.GameConnectionRegistry;

import static java.lang.Long.parseLong;

@WebSocket(path = "/ws/game/{gameId}")
@ApplicationScoped
public class GameWebSocket {
    @Inject
    WebSocketConnection connection;
    @Inject
    GameConnectionRegistry connectionRegistry;

    @OnOpen
    public String onOpen(WebSocketConnection connection) {
        // Get GameID
        String gameId = connection.pathParam("gameId");

        // Add Game to Registry
        connectionRegistry.add(parseLong(gameId), connection);

        // Welcome Message
        return """
               {
                 "type":"Message",
                 "gameId":"%s",
                 "message":"You are connected"
               }
               """.formatted(gameId);
    }

    @OnTextMessage
    public void onMessage(String message) {
        // Get GameID
        String gameId = connection.pathParam("gameId");

        // Broadcast Message
        connectionRegistry.broadcastToGame(parseLong(gameId), """
        {
         "type":"Message",
         "gameId":"%s",
         "message":"%s"
        }
        """.formatted(gameId, message));
    }

    @OnClose
    public void onClose(WebSocketConnection connection) {
        String gameId = connection.pathParam("gameId");

        connectionRegistry.remove(parseLong(gameId), connection);
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("WS ERROR:");
        t.printStackTrace();
    }
}