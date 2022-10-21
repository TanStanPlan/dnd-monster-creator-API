package com.revature.dndmonstercreator.user.dto.responses;

import com.revature.dndmonstercreator.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String email;
    private String username;
    private String password;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
