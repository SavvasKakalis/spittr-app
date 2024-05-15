package main.java;

import javax.persistence.*;

@Entity
@Table(name="spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // Variable to store the username of the Spitter
    @Column(name="username")
    private String username;


    // Variable to store the password of the Spitter
    @Column(name="password")
    private String password;

    // Variable to store the fullname of the Spitter
    @Column(name="fullName")
    private String fullName;

    public Spitter() {}

    public Spitter(int id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spitter{");
        sb.append("id='").append(id).append('\'');
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
