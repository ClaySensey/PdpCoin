package org.example.modul;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@AllArgsConstructor
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

    public BigDecimal getGrade() {
        return grade;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRole() {
        return Role;
    }

    public String getUsername() {
        return username;
    }

    public BotState getState() {
        return BotState.valueOf(String.valueOf(state));
    }

    public void add(Student newUser) {

    }
}