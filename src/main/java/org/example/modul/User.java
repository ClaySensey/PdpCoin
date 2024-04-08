package org.example.modul;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.modul.BotState;
import org.example.modul.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long chatId;
    private String fullName;
    private Role role;
    private String grade;
    private BotState botState;
}
