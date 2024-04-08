package org.example.modul;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Teacher {
    private long chatId;
    private String fullname;
    private String Role;
    private String username;
    private BotState state;

    public Teacher() {

    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BotState getState() {
        return state;
    }

    public void setState(BotState state) {
        this.state = state;
    }

    public void add(Student newUser) {

    }
}