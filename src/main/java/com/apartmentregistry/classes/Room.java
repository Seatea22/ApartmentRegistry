package com.apartmentregistry.classes;

import java.util.Objects;

public class Room {

    private int roomId;
    private String attendant;

    public Room(int roomId, String attendant) {
        this.roomId = roomId;
        this.attendant = attendant;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getAttendant() {
        return attendant;
    }

    public void setAttendant(String attendant) {
        this.attendant = attendant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomId == room.roomId && Objects.equals(attendant, room.attendant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, attendant);
    }
}
