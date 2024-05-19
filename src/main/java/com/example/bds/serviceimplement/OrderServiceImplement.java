package com.example.bds.serviceimplement;

import com.example.bds.Request.OrderRequest.CreateOrderRequest;
import com.example.bds.Response.OrderResponse.CreateOrderResponse;
import com.example.bds.Response.OrderResponse.OrderResponse;
import com.example.bds.enums.Role;
import com.example.bds.model.Cart;
import com.example.bds.model.Order;
import com.example.bds.model.User;
import com.example.bds.repository.CartRepo;
import com.example.bds.repository.OrderRepo;
import com.example.bds.repository.UserRepo;
import com.example.bds.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CartRepo cartRepository;
    @Override
    public ResponseEntity<OrderResponse> getAll() {
        List<Order> orders = orderRepo.findAll();
        OrderResponse response = new OrderResponse();
        response.setStatus("success");
        response.setMessage("Orders retrieved successfully");
        response.setOrders(orders);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<OrderResponse> deleteOrder(int orderId) {
        // Check if the package exists
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            // Package found, delete it
            orderRepo.deleteById(orderId);

            // Prepare the response
            OrderResponse response = OrderResponse.builder()
                    .status("Success")
                    .message("Order deleted successfully")
                    .build();

            return ResponseEntity.ok(response);
        } else {
            // Package not found, return an appropriate error response
            OrderResponse response = OrderResponse.builder()
                    .status("Error")
                    .message("Package not found")
                    .build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


        @Override
        public ResponseEntity<OrderResponse> searchOrders(LocalDate fromDate, LocalDate toDate) {
            List<Order> orders = orderRepo.findByOrderDateBetween(fromDate.atStartOfDay(), toDate.atTime(23, 59, 59));

            OrderResponse response;
            if (!orders.isEmpty()) {
                response = OrderResponse.builder()
                        .status("Success")
                        .message("Orders found within the date range")
                        .orders(orders)
                        .build();
                return ResponseEntity.ok(response);
            } else {
                response = OrderResponse.builder()
                        .status("Error")
                        .message("No orders found within the date range")
                        .build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        int audience = request.getAudience();
        double orderPrice = request.getOrderPrice();
        LocalDateTime postedAt = LocalDateTime.now();
        var user = userRepo.findUserByUsersID(audience).orElse(null);
        if(user != null && (user.getRole() == Role.AUDIENCE || user.getRole()==Role.CREATOR)){
            double balance = user.getAccountBalance();
            if(balance>=orderPrice){
                user.setAccountBalance(user.getAccountBalance()-orderPrice);
                List<Cart> cartItems = cartRepository.findByUser(user);
                if (!cartItems.isEmpty()) {
                    Order order = Order.builder()
                            .orderDate(postedAt)
                            .orderPrice(orderPrice)
                            .audience(user)
                            .build();
                    orderRepo.save(order);
                    userRepo.save(user);
                    return CreateOrderResponse.builder()
                            .status("Create order successful")
                            .order(order)
                            .build();
                }else {
                    return CreateOrderResponse.builder()
                            .status("Create fail")
                            .order(null)
                            .build();
                }

            }else {
                return CreateOrderResponse.builder()
                        .status("Your balance is not enough")
                        .order(null)
                        .build();
            }
        }
        else {
            return CreateOrderResponse.builder()
                    .status("User not found")
                    .order(null)
                    .build();
        }
    }

    @Override
    public List<Order> getOrdersByAudience(User audience) {
        return orderRepo.findOrderByAudience(audience);
    }


}
