package com.revature.dndmonstercreator.util.web.DTO.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginCreds {
    private String email;
    private String password;
}
