package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.DTO.UserDTO;
import com.FoodDeliveryApp.demo.Exceptions.UserException;
import com.FoodDeliveryApp.demo.Model.Address;
import com.FoodDeliveryApp.demo.Model.FoodCart;
import com.FoodDeliveryApp.demo.Model.User;
import com.FoodDeliveryApp.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AdressService adressService;

    @Autowired
    CartService cartService;

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws UserException {

        Optional<User> availableUserOpt = userRepository.findByEmail(userDTO.getEmail());

        if(availableUserOpt.isPresent()){
            throw new UserException("User already exists with email : "+userDTO.getEmail());
        }

        User user = getUserFromDTO(userDTO);

        User savedUser = userRepository.save(user);

        FoodCart foodCart = new FoodCart();

        foodCart.setUser(user);

        Address address = userDTO.getAddress();

        Address savedAddress = adressService.saveAddress(address);

        FoodCart savedCart = cartService.saveFoodCart(foodCart);

        savedUser.setAddressId(savedAddress.getAddressId());

        savedUser.setFoodCartId(savedCart.getCartId());

        User dtoForUser = userRepository.save(savedUser);

        UserDTO savedDTO = getUserDTOFromUser(dtoForUser);

        return savedDTO;


    }

    @Override
    public User updateUser(UserDTO userDTO) {

        User validatedUser = validateUserById(userDTO.getUserId());

        if(userDTO.getEmail().equals(validatedUser.getEmail())){

            if(userDTO.getEmail()!=null) {

                User user = getUserFromDTO(userDTO);
                user.setAddressId(userDTO.getAddress().getAddressId());
                Address address = userDTO.getAddress();

                Address updatedAddress = adressService.saveAddress(address);
                return userRepository.save(user);

            }
        }

        Optional<User> availableUserWithEmail = userRepository.findByEmail(userDTO.getEmail());

        if(availableUserWithEmail.isPresent()) throw new UserException("Email already exists");

        User user = getUserFromDTO(userDTO);

        user.setAddressId(validatedUser.getAddressId());
        user.setFoodCartId(validatedUser.getFoodCartId());

        return userRepository.save(user);

    }

    @Override
    public User removeUser(Integer userId) {

        User user = validateUserById(userId);

        userRepository.delete(user);

        restTemplate.delete("http://ADDRESS-SERVICE/"+user.getAddressId());

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


    private User getUserFromDTO(UserDTO userDTO){

        User user = new User();

        user.setUserId(userDTO.getUserId());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobile(userDTO.getMobile());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        return user;



    }


    private UserDTO getUserDTOFromUser(User user){

        Address address = adressService.getAddress(user.getAddressId());

        FoodCart foodCart = cartService.getFoodCart(user.getFoodCartId());

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getAge());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMobile(user.getMobile());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setFoodCart(foodCart);
        userDTO.setAddress(address);

        return userDTO;


    }

}
