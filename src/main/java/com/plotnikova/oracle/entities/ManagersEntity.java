package com.plotnikova.oracle.entities;

import javax.persistence.*;
import java.sql.Time;

@Table(name = "MANAGERS", schema = "TEST_USER", catalog = "")
public class ManagersEntity {
    private long managerId;
    private String firstName;
    private String lastName;
    private Time dateBirth;
    private String position;
    private Long salary;

    @Id
    @Column(name = "MANAGER_ID")
    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "DATE_BIRTH")
    public Time getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Time dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Basic
    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "SALARY")
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagersEntity that = (ManagersEntity) o;

        if (managerId != that.managerId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (dateBirth != null ? !dateBirth.equals(that.dateBirth) : that.dateBirth != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (managerId ^ (managerId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
