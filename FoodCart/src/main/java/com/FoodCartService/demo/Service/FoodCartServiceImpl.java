package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.DTO.FoodCartDTO;
import com.FoodCartService.demo.DTO.ItemDTO;
import com.FoodCartService.demo.Exceptions.CartException;
import com.FoodCartService.demo.Exceptions.RestaurantException;
import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Item;
import com.FoodCartService.demo.Model.Restaurant;
import com.FoodCartService.demo.Repository.FoodCartRepository;
import com.FoodCartService.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodCartServiceImpl implements FoodCartService{

    @Autowired
    FoodCartRepository foodCartRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public FoodCartDTO createCartForUser(FoodCartDTO foodCartDTO){

        FoodCart foodCart = getCartFromDTO(foodCartDTO);

        FoodCart savedCart = foodCartRepository.save(foodCart);

        foodCartDTO.setCartId(savedCart.getCartId());

        return foodCartDTO;

    }

    @Override
    public FoodCart addItemToCart(Integer cartId, Integer itemId, Integer restaurantId) {

        FoodCart foodCart = validateCart(cartId);

        List<Item> items = foodCart.getItems();

       Boolean isPresent = items.stream().anyMatch((i)-> i.getItemId()== itemId);

        if(isPresent){
            throw new CartException("Item already present in the cart");
        }

        Restaurant restaurant = restTemplate.getForObject("http://RESTAURANT-SERVICE/fooddelivery/restaurant"+restaurantId, Restaurant.class);

        if(restaurant==null){
            throw new RestaurantException("Restaurant does not exists with restaurant id : "+restaurantId);
        }

        List<ItemDTO> restaurantItems = restaurant.getItems();

        Optional<ItemDTO> itemOpt = restaurantItems.stream().filter((el)-> el.getItemId()==itemId).findAny();

        if(itemOpt.isPresent()) throw new RestaurantException("item does not exists in this restaurant");

        ItemDTO itemDTO = itemOpt.get();

        itemDTO.setRestaurant(restaurant);

        itemDTO.getFoodCarts().add(foodCart);

        Item item = itemService.getItemFromDTO(itemDTO);

        foodCart.getItems().add(item);

        return foodCartRepository.save(foodCart);



    }

    @Override
    public FoodCart increaseOrReduceQuantityOfItem(Integer cartId, Integer itemId, Integer quantity) {

        FoodCart foodCart = validateCart(cartId);

        List<Item> items = foodCart.getItems();

        Optional<Item> itemOpt = items.stream().filter((el)-> el.getItemId()==itemId).findAny();

        if(itemOpt.isPresent()) throw new RuntimeException("item does not exists with item id : "+itemId);

        Item savedItem = itemOpt.get();

        savedItem.setQuantity(quantity);

        itemRepository.save(savedItem);

        return validateCart(cartId);
    }

    @Override
    public FoodCart removeItemFromCart(Integer cartId, Integer itemId) {

        FoodCart validatedCart = validateCart(cartId);

        itemService.validateItem(itemId);

        itemService.removeItem(itemId, cartId);

        return validateCart(cartId);

    }

    @Override
    public FoodCart clearCart(Integer cartId) {

        FoodCart validatedCart = validateCart(cartId);

        itemRepository.clearCart(cartId);

        return validateCart(cartId);

    }

    private FoodCart validateCart(Integer cartId){
        return foodCartRepository.findById(cartId).orElseThrow(()-> new CartException("Cart does not exists with id : "+cartId));
    }

    private FoodCart getCartFromDTO(FoodCartDTO foodCartDTO){

        FoodCart foodCart = new FoodCart();

        foodCart.setUserId(foodCartDTO.getUser().getUserId());

        foodCart.setItems(foodCartDTO.getItems());

        foodCart.setCartId(foodCartDTO.getCartId());

        return foodCart;


    }

    private FoodCart getCartDTOFromCart(FoodCartDTO foodCartDTO){

        FoodCart foodCart = new FoodCart();

        foodCart.setUserId(foodCartDTO.getUser().getUserId());

        foodCart.setItems(foodCartDTO.getItems());

        foodCart.setCartId(foodCartDTO.getCartId());

        return foodCart;


    }

}
