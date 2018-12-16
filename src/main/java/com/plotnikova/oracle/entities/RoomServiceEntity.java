package com.plotnikova.oracle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_SERVICE", schema = "TEST_USER", catalog = "")
public class RoomServiceEntity {
    private long roomServiceId;

    @Id
    @Column(name = "ROOM_SERVICE_ID")
    public long getRoomServiceId() {
        return roomServiceId;
    }

    public void setRoomServiceId(long roomServiceId) {
        this.roomServiceId = roomServiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomServiceEntity that = (RoomServiceEntity) o;

        if (roomServiceId != that.roomServiceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (roomServiceId ^ (roomServiceId >>> 32));
    }
}
