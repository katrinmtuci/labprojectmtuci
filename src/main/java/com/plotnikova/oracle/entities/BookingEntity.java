package com.plotnikova.oracle.entities;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING", schema = "TEST_USER", catalog = "")
public class BookingEntity {
    private long bookingId;
    private String status;
    private String guestFirstName;
    private String guestLastName;

    @Id
    @Column(name = "BOOKING_ID")
    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "GUEST_FIRST_NAME")
    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    @Basic
    @Column(name = "GUEST_LAST_NAME")
    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingEntity that = (BookingEntity) o;

        if (bookingId != that.bookingId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (guestFirstName != null ? !guestFirstName.equals(that.guestFirstName) : that.guestFirstName != null)
            return false;
        if (guestLastName != null ? !guestLastName.equals(that.guestLastName) : that.guestLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookingId ^ (bookingId >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (guestFirstName != null ? guestFirstName.hashCode() : 0);
        result = 31 * result + (guestLastName != null ? guestLastName.hashCode() : 0);
        return result;
    }
}
