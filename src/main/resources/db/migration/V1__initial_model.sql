CREATE TABLE IF NOT EXISTS game (
                      id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                      game_status VARCHAR(32) NOT NULL,
                      current_player_id BIGINT UNSIGNED NULL,
                      created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

CREATE TABLE game_state (
    game_id BIGINT UNSIGNED NOT NULL,
    state_json LONGBLOB NOT NULL,

    PRIMARY KEY (game_id),

    FOREIGN KEY (game_id) REFERENCES game(id)
);

CREATE TABLE action (
                        action_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                        game_id   BIGINT UNSIGNED NOT NULL,
                        actor_id  VARCHAR(48) NOT NULL,
                        client_action_id BIGINT NOT NULL,
                        type      VARCHAR(64) NOT NULL,
                        payload_json LONGBLOB,
                        created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

                        PRIMARY KEY (action_id),

                        CONSTRAINT fk_action_game
                            FOREIGN KEY (game_id) REFERENCES game(id),

                        CONSTRAINT uq_action_game_client
                            UNIQUE (game_id, client_action_id)
);