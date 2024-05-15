package main.java;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="spittle")
public class Spittle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // Variable to store the message/description of the Spittle (post)
    @Column(name="message")
    private String message;

    // Variable to store the time that the Spittle was created
    @Column(name="time_submitted", columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
    private Timestamp timeSubmitted;

    // Variable to store the Spitter (creator) of the Spittl
    @Column(name="spitter")
    private String spitter;

    public Spittle(){}

    public Spittle(int id, String message, Timestamp timeSubmitted, String spitter) {
        this.id = id;
        this.message = message;
        this.timeSubmitted = timeSubmitted;
        this.spitter = spitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(Timestamp timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public String getSpitter() {
        return spitter;
    }

    public void setSpitter(String spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spittle{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", timeSubmitted=").append(timeSubmitted);
        sb.append(", spitter=").append(spitter);
        sb.append('}');
        return sb.toString();
    }
}
