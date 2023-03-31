package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Exceptions.UserException;
import com.FoodDeliveryApp.demo.Model.User;
import java.util.List;

public interface UserService {

    public User registerUser(User user) throws UserException;

    public User updateUser(User user);

    public User removeUser(Integer userId);

    public User viewUser(Integer userId);

    public List<User> viewAllUser();

}
