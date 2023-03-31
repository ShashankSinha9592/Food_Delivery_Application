package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Exceptions.UserException;
import com.FoodDeliveryApp.demo.Model.User;
import com.FoodDeliveryApp.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) throws UserException {

        Optional<User> availableUserOpt = userRepository.findByEmail(user.getEmail());

        if(availableUserOpt.isPresent()){
            throw new UserException("User already exists with email : "+user.getEmail());
        }

        return userRepository.save(user);

    }

    @Override
    public User updateUser(User user) {

        User validatedUser = validateUserById(user.getUserId());

        if(user.getEmail().equals(validatedUser.getEmail())){
            return userRepository.save(user);
        }

        Optional<User> availableUserWithEmail = userRepository.findByEmail(user.getEmail());

        if(availableUserWithEmail.isPresent()) throw new UserException("Email already exists");

        return userRepository.save(user);

    }

    @Override
    public User removeUser(Integer userId) {

        User user = validateUserById(userId);

        userRepository.delete(user);

        return user;
    }

    @Override
    public User viewUser(Integer userId) {

        return validateUserById(userId);

    }

    @Override
    public List<User> viewAllUser() {

        List<User> users = userRepository.findAll();

        if(users.isEmpty()) throw new UserException("Users not found");

        return users;
    }


    private User validateUserById(Integer userId){

        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User does not exists with user id : "+userId));

        return  user;

    }

}
