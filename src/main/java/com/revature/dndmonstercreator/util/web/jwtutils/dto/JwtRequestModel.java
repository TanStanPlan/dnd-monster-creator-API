package com.revature.dndmonstercreator.util.web.jwtutils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequestModel implements Serializable {

    private static final long serialVersionUID = 2636939296391265891L;
    private String username;
    private String password;

}
