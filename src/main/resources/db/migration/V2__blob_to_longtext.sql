-- game_state.state_json: LONGBLOB -> LONGTEXT (NOT NULL)
ALTER TABLE game_state
    MODIFY COLUMN state_json LONGTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL;

-- action.payload_json: LONGBLOB -> LONGTEXT (NULL allowed, as before)
ALTER TABLE `action`
    MODIFY COLUMN payload_json LONGTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL;