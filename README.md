![Food Delivery](https://user-images.githubusercontent.com/102857782/231255009-40c63874-0f86-4129-92f7-b560906ff85b.jpeg)



# Food_Delivery_Microservices_Application
A food delivery application system allows users to browse items and order food online in an easy and efficient manner

### Summary
This microservices is created to demonstrate how to split sample Spring application into microservices.
To achieve that goal I use Spring Cloud Gateway, Spring Cloud Circuit Breaker, Resilience4j, Retry Module, Rate Limiter, Feign Client
and the Eureka Service Discovery Client/Server from the Spring Cloud Netflix technology stack.


### Services
#### User Service : This service manages the data of a user.
##### Features :
* Add user
* Update user
* Remove user
* view user
* view all users
* etc
#### Restaurant-Item Service : This service manages the data of a restaurant and items.
##### Restaurant Service
##### Features :
* Add restaurant
* Update restaurant
* Remove Restaurant
* View restaurant by id
* View all reataurant
* View restaurant by location
* View restaurant by item
* Add item to restaurant menu
* etc
##### Item Service
* Add item
* Update item
* View item by id
* View all items
* View items by restaurant
* Remove item
* etc
#### Order-Details Service : This service manages the orders ordered by a user.
##### Features :
* Add Order
* Update Order
* Delete Order
* View Order
* View order of a customer
* etc
#### FoodCart Service : This service manages the data of a foodcart and items in foodcart. 
##### Features :
* Add Cart : Note : cart automatically gets created when new user signup. 
* Update cart
* Remove Cart : Note : Cart automatically gets removed when user removes his account
* View Cart
* View Cart of a user
* Add Items to cart
* Increase or decrease quantity of an item in the cart
* Clear cart
* Remove item from cart
* etc

#### Category Service : This service manages the data of a category in which items are present
##### Features :
* Add Category
* Remove Category
* Update Category
* View Category 
* View category by name
* View all category

#### Bill Service : This service manages the bills related to order of a customer
##### Features : 
* Add bill
* Remove bill
* Update bill
* View bill
* View bill by date
* View bill of a user
* Calculate bill

#### Address Service : This service manages the address related to restaurant or user.
##### Features :
* Add address : Note : Address taken by user or reataurant and it automatocally gets created when new user or restaurant gets created 
* Update address
* Remove address : Automatocally gets removed when when mapped user or reataurant gets removed.
* View address

#### Api Gateway : This service is used to catch all the request for all the services and transfer it to that specific service in which it's URI is mapped to.

#### Service Registry : This service provides registration of all the users to monitor the services is up or down and to gove them their unique names.


#### Pending works : 
* Implementing security to the services
* Payment service implementation
* Messaging Queue and Saga to handle Distributed Transactions
* Docker

### Starting a service locally
Every microservice is a Spring Boot application and can be started locally using IDE (Lombok plugin has to be set up) or ../mvnw spring-boot:run command. Please note that supporting services (Discovery Server and API Gateway) must be started before any other application.


## Api Documentation




