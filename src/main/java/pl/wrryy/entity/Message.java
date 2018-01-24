package pl.wrryy.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User addressee;

    private String text;
    private LocalDateTime created;

    public Message() {
        this.created = LocalDateTime.now();
    }
    public String getCreatedd() {
        return Arrays.toString(created.toString().split("T"));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getAddressee() {
        return addressee;
    }

    public void setAddressee(User addressee) {
        this.addressee = addressee;
    }
}

