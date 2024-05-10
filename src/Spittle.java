import java.time.LocalDateTime;

public class Spittle {

    // Variable to store the message/description of the Spittle (post)
    private String message;

    // Variable to store the time that the Spittle was created
    private LocalDateTime timeSubmitted;

    // Variable to store the Spitter (creator) of the Spittle
    private Spitter spitter;

    public Spittle(String message, LocalDateTime timeSubmitted, Spitter spitter) {
        this.message = message;
        this.timeSubmitted = timeSubmitted;
        this.spitter = spitter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTime(LocalDateTime timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spittle{");
        sb.append("message='").append(message).append('\'');
        sb.append(", time=").append(timeSubmitted);
        sb.append(", spitter=").append(spitter);
        sb.append('}');
        return sb.toString();
    }
}
