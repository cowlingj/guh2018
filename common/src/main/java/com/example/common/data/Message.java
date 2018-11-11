package com.example.common.data;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.Serializable;
import java.time.Instant;

public class Message implements Serializable {

    @NotNull public final MessageType type;
    @Nullable public final String id;
    @Nullable public final String name;
    @Nullable public final Float amount;
    @Nullable public final Integer x;
    @Nullable public final Integer y;
    @Nullable public final Integer heading;
    @Nullable public final Integer turretHeading;
    @Nullable public final String health;
    @Nullable public final String ammo;
    @Nullable public final Instant date;
    
    public Message(MessageType type, String id, String name, Float amount, Integer x, Integer y, Integer heading, Integer turretHeading, String health, String ammo, String time) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.turretHeading = turretHeading;
        this.health = health;
        this.ammo = ammo;
        this.date = Instant.parse(time);
        this.type = type;
    }

    public static Message createTank(String name) {
        return new Message(MessageType.CREATE_TANK,null, name, null, null, null, null, null, null, null, null);
    }

    public static Message withAmount(Float amount, MessageType type) {
        return new Message(type,null, null, amount, null, null, null, null, null, null, null);
    }

    public static Message objectUpdate(String id, String name) {
        return new Message(MessageType.OBJECT_UPDATE,id, name, null, null, null, null, null, null, null, null);
    }

    public static Message snitchPickup(String id) {
        return new Message(MessageType.SNITCH_PICKUP,id, null, null, null, null, null, null, null, null, null);
    }

    public static Message gameTimeUpdated(String time) {
        return new Message(MessageType.GAME_TIME_UPDATE,null, null, null, null, null, null, null, null, null, time);
    }

    public static Message emptyMessage(MessageType type) {
        return new Message(type,null, null, null, null, null, null, null, null, null, null);

    }
}
