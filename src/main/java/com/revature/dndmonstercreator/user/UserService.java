package com.revature.dndmonstercreator.user;

import com.revature.dndmonstercreator.user.dto.requests.NewUserRegistrationRequest;
import com.revature.dndmonstercreator.user.dto.requests.UpdateUserRequest;
import com.revature.dndmonstercreator.user.dto.responses.UserResponse;
import com.revature.dndmonstercreator.util.exceptions.InvalidUserInputException;
import com.revature.dndmonstercreator.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {

    private final UserRepository userRepository;

    //Not necessary for the constructor for Autowired
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public UserResponse register(NewUserRegistrationRequest registrationRequest) throws InvalidUserInputException{
        User newUser = new User(registrationRequest);
        isEmailAvailable(newUser.getEmail());
        isUsernameAvailable(newUser.getUsername());
        return new UserResponse(userRepository.save(newUser));
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
    public void update(UpdateUserRequest updateUserRequest, User currentUser) throws InvalidUserInputException{
        User foundUser = userRepository.findById(currentUser.getId()).orElseThrow(ResourceNotFoundException::new);
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

}
