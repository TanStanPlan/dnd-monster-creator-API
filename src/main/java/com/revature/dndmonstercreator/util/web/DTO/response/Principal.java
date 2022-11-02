package com.revature.dndmonstercreator.util.web.DTO.response;

import com.revature.dndmonstercreator.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Principal {
    @NotBlank
    private int id;

    @NotBlank
    private String email;

    public Principal(User authUser){
        this.id = authUser.getId();
        this.email = authUser.getEmail();
    }

    public User extractUser() {return new User(id, email);}

}
