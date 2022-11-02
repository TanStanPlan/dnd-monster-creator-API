package com.revature.dndmonstercreator.util.web;

import com.revature.dndmonstercreator.user.User;
import com.revature.dndmonstercreator.user.UserService;
import com.revature.dndmonstercreator.util.web.DTO.request.LoginCreds;
import com.revature.dndmonstercreator.util.web.DTO.response.Principal;
import com.revature.dndmonstercreator.util.web.jwtutils.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(exposedHeaders = "Authorization")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TokenManager tokenManager;

    @Autowired
    public AuthController(UserService userService, TokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @PostMapping
    public Principal authorizeUser(@RequestBody LoginCreds loginCreds, HttpServletResponse httpServletResponse){
        User authUser = userService.login(loginCreds.getEmail(), loginCreds.getPassword());
        Principal payload = new Principal(authUser);
        String token = tokenManager.generateJwtToken(payload);
        httpServletResponse.setHeader("Authorization", token);
        return payload;
    }
}
