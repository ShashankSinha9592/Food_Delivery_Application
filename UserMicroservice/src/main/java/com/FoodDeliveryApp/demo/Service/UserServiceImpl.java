package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.DTO.FoodCartDTO;
import com.FoodDeliveryApp.demo.DTO.UserDTO;
import com.FoodDeliveryApp.demo.Exceptions.UserException;
import com.FoodDeliveryApp.demo.Model.Address;
import com.FoodDeliveryApp.demo.Model.FoodCart;
import com.FoodDeliveryApp.demo.Model.User;
import com.FoodDeliveryApp.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdressService adressService;

    @Autowired
    CartService cartService;

    @Override
    @Transactional
    public UserDTO registerUser(UserDTO userDTO) throws UserException {

        Optional<User> availableUserOpt = userRepository.findByEmail(userDTO.getEmail());

        if(availableUserOpt.isPresent()) throw new UserException("User already exists with email : "+userDTO.getEmail());

        User user = getUserFromDTO(userDTO);

        User savedUser = userRepository.save(user);

        FoodCartDTO foodCartDTO = new FoodCartDTO();

        foodCartDTO.setUserId(savedUser.getUserId());

        FoodCartDTO savedCartDto = cartService.saveFoodCart(foodCartDTO);

        Address address = userDTO.getAddress();

        Address savedAddress = adressService.saveAddress(address);

        savedUser.setAddressId(savedAddress.getAddressId());

        savedUser.setFoodCartId(savedCartDto.getCartId());

        User updatedUser = userRepository.save(savedUser);

        UserDTO savedDTO = getUserDTOFromUser(updatedUser);

        return savedDTO;

    }

    @Override
    public User updateUser(UserDTO userDTO) {

//        User validatedUser = validateUserById(userDTO.getUserId());
//
//        if(validatedUser.getEmail().equals(userDTO.getEmail())){
//
//            if(userDTO.getEmail()!=null) {
//
//                User user = getUserFromDTO(userDTO);
//                user.setAddressId(userDTO.getAddress().getAddressId());
//                Address address = userDTO.getAddress();
//
//                Address updatedAddress = adressService.saveAddress(address);
//
//                return userRepository.save(user);
//
//            }
//        }
//
//        Optional<User> availableUserWithEmail = userRepository.findByEmail(userDTO.getEmail());
//
//        if(availableUserWithEmail.isPresent()) throw new UserException("Email already exists");
//
//        User user = getUserFromDTO(userDTO);
//
//        user.setAddressId(validatedUser.getAddressId());
//        user.setFoodCartId(validatedUser.getFoodCartId());
//
//        return userRepository.save(user);
        return null;

    }

    @Override
    public User removeUser(Integer userId) {

        User user = validateUserById(userId);

        cartService.removeCart(user.getFoodCartId());

        adressService.deleteAddress(user.getAddressId());

        userRepository.delete(user);

        return user;
    }

    @Override
    public UserDTO viewUser(Integer userId) {

        return getUserDTOFromUser(validateUserById(userId));

    }

    @Override
    public List<User> viewAllUser() {

        List<User> users = userRepository.findAll();

        if(users.isEmpty()) throw new UserException("Users not found");

        return users;
    }


    private User validateUserById(Integer userId){

        return userRepository.findById(userId).orElseThrow(()-> new UserException("User does not exists with user id : "+userId));

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
        user.setAge(userDTO.getAge());

        return user;

    }


    private UserDTO getUserDTOFromUser(User user){

        Address address = adressService.getAddress(user.getAddressId());

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMobile(user.getMobile());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setAddress(address);
        userDTO.setAge(user.getAge());

        return userDTO;

    }

}
