package com.gamescore.domain;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public class User {

    private ObjectId _id;
    private String nick;
    private String email;
    private String password;
    private Boolean state = Boolean.TRUE;

    private List<VideogameAcquired> videogameAcquired;

    //Constructores
    public User() {
    }

    public User(ObjectId _id) {
        this._id = _id;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String nick, String email, String password) {
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                '}';
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
