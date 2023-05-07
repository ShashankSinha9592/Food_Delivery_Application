package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.DTO.UserDTO;
import com.FoodDeliveryApp.demo.Exceptions.UserException;
import com.FoodDeliveryApp.demo.Model.User;
import java.util.List;

public interface UserService {

    public UserDTO registerUser(UserDTO userDTO) throws UserException;

    public User updateUser(UserDTO user);

    public User removeUser(Integer userId);

    public UserDTO viewUser(Integer userId);

    public List<User> viewAllUser();

}
