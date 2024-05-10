import java.util.Date;

public class Spittle {

    private Long id;
    private String message;
    private Date time;
    private Spitter spitter;

    public Spittle(Long id, String message, Date time, Spitter spitter) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.spitter = spitter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", spitter=" + spitter +
                '}';
    }
}
