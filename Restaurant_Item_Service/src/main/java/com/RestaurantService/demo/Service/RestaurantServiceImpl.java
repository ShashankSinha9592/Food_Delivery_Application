package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.DTO.RestaurantDTO;
import com.RestaurantService.demo.DTO.RestaurantsInItemDTO;
import com.RestaurantService.demo.Exceptions.ItemException;
import com.RestaurantService.demo.Exceptions.RestaurantException;
import com.RestaurantService.demo.Model.Address;
import com.RestaurantService.demo.Model.Item;
import com.RestaurantService.demo.Model.Restaurant;
import com.RestaurantService.demo.Repository.ItemRepository;
import com.RestaurantService.demo.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Override
    public RestaurantsInItemDTO addRestaurant(RestaurantsInItemDTO restaurantDTO) {

        Address address = restTemplate.postForObject("http://ADDRESS-SERVICE/fooddelivery/address", restaurantDTO.getAddress(), Address.class);

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setContact(restaurantDTO.getContact());
        restaurant.setAddressId(address.getAddressId());
        restaurant.setManagerName(restaurantDTO.getManagerName());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return getDTOFromRestaurant(savedRestaurant);

    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {

        Restaurant savedRestaurant = validateRestaurant(restaurant.getRestaurantId());

        restaurant.setAddressId(savedRestaurant.getAddressId());

        return restaurantRepository.save(restaurant);

    }

    @Override
    public Restaurant removeRestaurant(Integer restaurantId) {

        Restaurant savedRestaurant = validateRestaurant(restaurantId);

        restTemplate.delete("http://ADDRESS-SERVICE/fooddelivery/"+savedRestaurant.getAddressId());

        restaurantRepository.delete(savedRestaurant);

        return savedRestaurant;

    }

    @Override
    public RestaurantDTO viewRestaurant(Integer restaurantId) {

        Restaurant restaurant = validateRestaurant(restaurantId);

        RestaurantDTO restaurantDTO = new RestaurantDTO();

        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setContact(restaurant.getContact());
        restaurantDTO.setManagerName(restaurant.getManagerName());
        restaurantDTO.setAddress(validateAddress(restaurant.getAddressId()));

        List<ItemsInRestaurantDTO> items = new ArrayList<>();

        List<Item> savedItems = restaurant.getItems();

        savedItems.stream().forEach((el)-> items.add(itemService.getDtoFromItem(el)));

        restaurantDTO.setItems(items);

        return restaurantDTO;

//        return validateRestaurant(restaurantId);

    }

    @Override
    public List<Restaurant> viewRestaurantByLocation(String location) {

        // PROBLEM : Needs optimization in relationship structure

        return null;


    }

    @Override
    public List<RestaurantsInItemDTO> viewRestaurantByItem(Integer itemId) {

        itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Invalid item id : "+itemId));

        List<RestaurantsInItemDTO> restaurants = new ArrayList<>(); // restaurantRepository.getRestaurantsByItem(itemId);

        if(restaurants.isEmpty()) throw new RestaurantException("No restaurant found");

        return restaurants;

    }

    @Override
    public Restaurant addItemToRestaurantMenu(Integer itemId, Integer restaurantId) {

        Restaurant restaurant = validateRestaurant(restaurantId);

        Item item = itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Invalid item id : "+itemId));

        item.getRestaurants().add(restaurant);

        restaurant.getItems().add(item);

        itemRepository.save(item);

        return restaurantRepository.save(restaurant);

    }

    private RestaurantsInItemDTO getDTOFromRestaurant(Restaurant restaurant){

        RestaurantsInItemDTO savedRestaurantDTO = new RestaurantsInItemDTO();

        savedRestaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        savedRestaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        savedRestaurantDTO.setContact(restaurant.getContact());
        savedRestaurantDTO.setAddress(validateAddress(restaurant.getAddressId()));
        savedRestaurantDTO.setManagerName(restaurant.getManagerName());

        return savedRestaurantDTO;
    }

    private Address validateAddress(Integer addressId){
        Address address = restTemplate.getForObject("http://ADDRESS-SERVICE/fooddelivery/"+addressId, Address.class);

        if(address==null) throw new RuntimeException("Invalid address id : "+addressId);

        return address;

    }

    private Restaurant validateRestaurant(Integer restaurantId){

        return restaurantRepository.findById(restaurantId).orElseThrow(()-> new RestaurantException("Invalid restaurant id : "+restaurantId));

    }
}
