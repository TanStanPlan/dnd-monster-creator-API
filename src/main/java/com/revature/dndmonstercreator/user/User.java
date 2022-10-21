package com.revature.dndmonstercreator.user;

import com.revature.dndmonstercreator.user.dto.requests.NewUserRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    public User(NewUserRegistrationRequest registrationRequest) {
        this.email = registrationRequest.getEmail();
        this.username = registrationRequest.getUsername();
        this.password = registrationRequest.getPassword();
    }

}
