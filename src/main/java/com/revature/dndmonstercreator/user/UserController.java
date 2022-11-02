package com.revature.dndmonstercreator.user;

import com.revature.dndmonstercreator.user.dto.requests.NewUserRegistrationRequest;
import com.revature.dndmonstercreator.user.dto.requests.UpdateUserRequest;
import com.revature.dndmonstercreator.user.dto.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserResponse> findAll(){
        return userService.readAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserResponse register(@RequestBody @Valid NewUserRegistrationRequest newUserRegistrationRequest){
        return userService.registerUser(newUserRegistrationRequest);
    }

    @PutMapping
    public String update(@RequestBody UpdateUserRequest updateUserRequest, @RequestHeader(name = "Authorization") String token){
        userService.update(updateUserRequest, tokenManager);
        return "The User has been successfully updated";
    }

    @DeleteMapping
    public String delete(@RequestParam int id){
        userService.deleteUser(id);
        return "The User has been successfully deleted!";
    }



}
