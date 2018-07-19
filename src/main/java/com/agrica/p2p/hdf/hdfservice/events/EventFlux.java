package com.agrica.p2p.hdf.hdfservice.events;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class EventFlux implements Serializable {



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;


    @Column(unique = true)
    private String name;


    private Date expectedAt;

    private Date arrivedAt;

    public EventFlux() {
    }

    public EventFlux(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Date getExpectedAt() {
        return expectedAt;
    }

    public void setExpectedAt(Date expectedAt) {
        this.expectedAt = expectedAt;
    }

    public Date getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(Date arrivedAt) {
        this.arrivedAt = arrivedAt;
    }


    @Override
    public String toString() {
        return "EventFlux{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", expectedAt=" + expectedAt +
                ", arrivedAt=" + arrivedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventFlux eventFlux = (EventFlux) o;
        return Objects.equals(id, eventFlux.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
