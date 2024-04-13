package org.example.modul;

import lombok.*;

import java.math.BigDecimal;
@ToString
public class Student {
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

    public String getGrade() {
        return String.valueOf(grade);
    }

    public String getFullname() {
        return fullname;
    }

    public org.example.modul.Role getRole() {
        return org.example.modul.Role.valueOf(Role);
    }

    public String getUsername() {
        return username;
    }

    public BotState getState() {
        return BotState.valueOf(String.valueOf(state));
    }

    public void add(Student newUser) {
        // bu nimaga kerak tushunmadim lekin o'chirmayman
    }
}