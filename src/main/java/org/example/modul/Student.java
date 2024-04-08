package org.example.modul;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student extends Teacher {
    private long chatId;
    private String fullname;
    private String Role;
    private String username;
    private BotState state;
    private BigDecimal grade;

    public Student() {

    }

    public long getChatId() {
        return chatId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
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
        return BotState.valueOf(String.valueOf(state));
    }

    public void setState(BotState state) {
        this.state = state;
    }

    public void add(Student newUser) {

    }
}