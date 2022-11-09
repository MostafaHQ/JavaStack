package com.mostafa.loginandregistration.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mostafa.loginandregistration.models.LoginUser;
import com.mostafa.loginandregistration.models.User;
import com.mostafa.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	
    private final UserRepository userRepository ;    
    
    public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findUserByEmail(String email) {
    	Optional <User> optionalUser = userRepository.findByEmail(email);
    	if (optionalUser.isPresent()) {
    		return optionalUser.get();
    	}else {
    		return null;
    	}
    }
    
    public User findUserById(Long id) {
    	Optional <User> optionalUser = userRepository.findById(id);
    	if (optionalUser.isPresent()) {
    		return optionalUser.get();
    	}else {
    		return null;
    	}
    }
    
    public List<User> allUsers(){
    	return userRepository.findAll();
    }
    
 public User register(User newUser, BindingResult result) {
        
    	Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email already exists");
    	}
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	String toCheckPattern = newUser.getUserName();
    	if (!toCheckPattern.matches("[a-zA-Z]+")) {
    		 result.rejectValue("userName", "Matches", "Must contain letters only");
		}
    	
    	if (result.hasErrors()) {
    		return null;
    	}
    	else {
        	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        	newUser.setPassword(hashed);
        	userRepository.save(newUser);
            return newUser;
    	} 
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		return null;
    	}
    	
    	Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Unknown email");
    		return null;
    	}
    	User user = potentialUser.get();
    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	if (result.hasErrors()) {
    		return null;
    	}else {
    		return user;
    	}
    }
    
}
