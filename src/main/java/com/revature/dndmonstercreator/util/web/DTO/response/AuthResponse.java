package com.revature.dndmonstercreator.util.web.DTO.response;

import com.revature.dndmonstercreator.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {

    private String email;
    private int id;

    public AuthResponse(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
    }
}
