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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FoodCartServiceImpl implements FoodCartService{

    @Autowired
    FoodCartRepository foodCartRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    RestaurantService restaurantService;

    @Override
    public FoodCartDTO createCartForUser(FoodCartDTO foodCartDTO){

        FoodCart foodCart = getCartFromDTO(foodCartDTO);

        FoodCart savedCart = foodCartRepository.save(foodCart);

        foodCartDTO.setCartId(savedCart.getCartId());

        return foodCartDTO;

    }

    public FoodCartDTO removeCart(Integer cartId){

        FoodCart foodCart = foodCartRepository.findById(cartId).orElseThrow(()-> new CartException("Innvalid cart id : "+cartId));

        foodCartRepository.delete(foodCart);

        return getCartDTOFromCart(foodCart);

    }

    @Override
    public FoodCartDTO viewCart(Integer cartId) {

        FoodCart foodCart = foodCartRepository.findById(cartId).orElseThrow(()-> new CartException("Invalid cart id : "+cartId));

        return getCartDTOFromCart(foodCart);

    }

    @Override
    public FoodCart getCartOfUser(Integer userId) {

        return foodCartRepository.findByUserId(userId).orElseThrow(()-> new CartException("Invalid user id : "+userId));

    }

    @Override
    public FoodCart addItemToCart(Integer cartId, Integer itemId, Integer restaurantId) {

        FoodCart foodCart = validateCart(cartId);

        List<Item> items = foodCart.getItems();

       Boolean isPresent = items.stream().anyMatch((item)-> item.getItemId()== itemId);

        if(isPresent) throw new CartException("Item already present in the cart");

        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

        if(restaurant==null) throw new RestaurantException("Restaurant does not exists with restaurant id : "+restaurantId);

        List<ItemDTO> restaurantItems = restaurant.getItems();

        Optional<ItemDTO> itemOpt = restaurantItems.stream().filter((el)-> el.getItemId()==itemId).findAny();

        if(itemOpt.isEmpty()) throw new RestaurantException("item does not exists in this restaurant");

        ItemDTO itemDTO = itemOpt.get();

        itemDTO.setRestaurant(restaurant);

        itemDTO.setFoodCart(foodCart);

        itemDTO.setQuantity(1);

        Item savedItem = itemService.addItem(itemDTO);

        foodCart.getItems().add(savedItem);

        return foodCartRepository.save(foodCart);

    }

    @Override
    public FoodCart increaseOrReduceQuantityOfItem(Integer cartId, Integer itemId, Integer quantity) {

        FoodCart foodCart = validateCart(cartId);

        List<Item> items = foodCart.getItems();

        Optional<Item> itemOpt = items.stream().filter((el)-> el.getItemId()==itemId).findAny();

        if(!itemOpt.isPresent()) throw new RuntimeException("item does not exists with item id : "+itemId);

        Item savedItem = itemOpt.get();

        savedItem.setQuantity(quantity+ savedItem.getQuantity());

        itemRepository.save(savedItem);

        return foodCart;
    }

    @Override
    public Item removeItemFromCart(Integer cartItemId) {

        Item itemToRemove = itemService.validateItem(cartItemId);

        itemRepository.delete(itemToRemove);

        return itemToRemove;

    }

    @Override
    public FoodCart clearCart(Integer cartId) {

        FoodCart validatedCart = validateCart(cartId);

//        itemRepository.clearCart(cartId);
        List<Item> items = validatedCart.getItems();

        items.forEach((item)-> itemRepository.delete(item));

        return validateCart(cartId);

    }

    private FoodCart validateCart(Integer cartId){
        return foodCartRepository.findById(cartId).orElseThrow(()-> new CartException("Cart does not exists with id : "+cartId));
    }

    private FoodCart getCartFromDTO(FoodCartDTO foodCartDTO){

        FoodCart foodCart = new FoodCart();

        foodCart.setUserId(foodCartDTO.getUserId());

        foodCart.setItems(foodCartDTO.getItems());

        foodCart.setCartId(foodCartDTO.getCartId());

        return foodCart;


    }

    private FoodCartDTO getCartDTOFromCart(FoodCart foodCart){

        FoodCartDTO foodCartDTO = new FoodCartDTO();

        foodCartDTO.setUserId(foodCart.getUserId());

        foodCartDTO.setItems(foodCart.getItems());

        foodCartDTO.setCartId(foodCart.getCartId());

        return foodCartDTO;


    }


}
