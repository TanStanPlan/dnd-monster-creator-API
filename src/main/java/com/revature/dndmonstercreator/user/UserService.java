package com.revature.dndmonstercreator.user;

import com.revature.dndmonstercreator.user.dto.requests.NewUserRegistrationRequest;
import com.revature.dndmonstercreator.user.dto.requests.UpdateUserRequest;
import com.revature.dndmonstercreator.user.dto.responses.UserResponse;
import com.revature.dndmonstercreator.util.exceptions.InvalidUserInputException;
import com.revature.dndmonstercreator.util.exceptions.ResourceNotFoundException;
import com.revature.dndmonstercreator.util.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    //Not necessary for the constructor for Autowired
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public UserResponse registerUser(NewUserRegistrationRequest registrationRequest) throws InvalidUserInputException{
        User newUser = new User(registrationRequest);
        isEmailAvailable(newUser.getEmail());
        isUsernameAvailable(newUser.getUsername());
        return new UserResponse(userRepository.save(newUser));
    }

    @Transactional
    public User login(String email, String password) throws UnauthorizedException{
        User user = userRepository.loginCredentialCheck(email, password).orElseThrow(ResourceNotFoundException::new);
        return user;

    }

    @Transactional(readOnly = true)
    public boolean isEmailAvailable(String email){
        if(userRepository.findByEmail(email).isPresent()){
            throw new InvalidUserInputException("Email: " + email + " is already registered, please try again.");
        }
        return true;
    }

    @Transactional(readOnly = true)
    public boolean isUsernameAvailable(String username){
        if(userRepository.findByUsername(username).isPresent()){
            throw new InvalidUserInputException("Username: " + username + " is already taken, please try another username");
        }
        return true;
    }

    @Transactional
    public void update(UpdateUserRequest updateUserRequest, int userId) throws InvalidUserInputException{
        User foundUser = userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new);
        Predicate<String> notNullorEmpty = (str) -> str != null && !str.trim().equals("");

        if(notNullorEmpty.test(updateUserRequest.getEmail())){
            foundUser.setEmail(updateUserRequest.getEmail());
        }
        if(notNullorEmpty.test(updateUserRequest.getUsername())){
            foundUser.setUsername(updateUserRequest.getUsername());
        }
        if(notNullorEmpty.test(updateUserRequest.getPassword())){
            foundUser.setPassword(updateUserRequest.getPassword());
        }
    }

    @Transactional(readOnly = true)
    public List<UserResponse> readAllUsers(){
        return ((Collection<User>)userRepository.findAll())
                .stream().map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponse findById(int id) {
        User user = userRepository.findById(id).orElseThrow(InvalidUserInputException::new);
        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    @Transactional
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
