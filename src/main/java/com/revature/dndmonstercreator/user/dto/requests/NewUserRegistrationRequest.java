package com.revature.dndmonstercreator.user.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRegistrationRequest {

    private String email;

    private String username;

    private String password;
}
