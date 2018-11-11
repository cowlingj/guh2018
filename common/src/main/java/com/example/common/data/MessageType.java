package com.example.common.data;

public enum MessageType {
    TEST(0),
    CREATE_TANK(1),
    DESPAWN_TANK(2),
    FIRE(3),
    TOGGLE_FORWARD(4),
    TOGGLE_REVERSE(5),
    TOGGLE_LEFT(6),
    TOGGLE_RIGHT(7),
    TOGGLE_TURRET_LEFT(8),
    TOGGLE_TURRET_RIGHT(9),
    TURN_TURRET_TO_HEADING(10),
    TURN_TO_HEADING(11),
    MOVE_FORWARD_DISTANCE(12),
    MOVE_BACKWARD_DISTANCE(13),
    STOP_ALL(14),
    STOP_TURN(15),
    STOP_MOVE(16),
    STOP_TURRET(17),
    OBJECT_UPDATE(18),
    HEALTH_PICKUP(19),
    AMMO_PICKUP(20),
    SNITCH_PICKUP(21),
    DESTROYED(22),
    ENTERED_GOAL(23),
    KILL(24),
    SNITCH_APPEARED(25),
    GAME_TIME_UPDATE(26),
    HIT_DETECTED(27),
    SUCCESSFUL_HIT(28);

    public final int code;

    MessageType(int code) {
        this.code = code;
    }
}
