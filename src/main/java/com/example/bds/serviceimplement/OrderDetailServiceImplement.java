package com.example.bds.serviceimplement;

import com.example.bds.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.bds.Response.OrderDetailResponse.CreateOrderDetailResponse;
import com.example.bds.Response.OrderDetailResponse.OrderDetailResponse;
import com.example.bds.model.Artwork;
import com.example.bds.model.Cart;
import com.example.bds.model.OrderDetail;
import com.example.bds.model.User;
import com.example.bds.repository.*;
import com.example.bds.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrderDetailServiceImplement implements OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private CartRepo cartRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    ArtworkRepo artworkRepo;

    @Override
    public ResponseEntity<OrderDetailResponse> getAllOrderDetails(int orderID) {
        List<OrderDetail> orderDetails = orderDetailRepo.findByOrder_OrderId(orderID);

        OrderDetailResponse response = new OrderDetailResponse();
        response.setStatus("success");
        response.setMessage("Order details retrieved successfully");
        response.setOrderDetails(orderDetails);

        return ResponseEntity.ok(response);
    }

    @Override
    public CreateOrderDetailResponse createOrderDetail(CreateOrderDetailRequest request) {
        int orderId = request.getOrderId();
        var order = orderRepo.findOrderByOrderId(orderId).orElse(null);
        if (order != null) {
            int audience = request.getAudience();
            var user = userRepo.findUserByUsersID(audience).orElse(null);
            if (user != null && user.getUsersID() == order.getAudience().getUsersID()) {
                List<Cart> cartItems = cartRepository.findByUser(user);
                if (!cartItems.isEmpty()) {
                    for (Cart cartItem : cartItems) {
                        OrderDetail orderDetail = OrderDetail.builder()
                                .artwork(cartItem.getArtwork())
                                .orderDetailPrice(cartItem.getArtwork().getPrice())
                                .order(order)
                                .build();
                        orderDetailRepo.save(orderDetail);
                        Artwork artwork = cartItem.getArtwork();

                        int currentBuyCount = (artwork.getBuyCount() == null) ? 0 : artwork.getBuyCount();
                        artwork.setBuyCount(currentBuyCount + 1);
//                        artwork.setBuyCount(cartItem.getArtwork().getBuyCount() + 1);
                        artworkRepo.save(artwork);
                        cartRepository.delete(cartItem);
                        User creator = orderDetail.getArtwork().getUser();
                        creator.setAccountBalance(creator.getAccountBalance() + orderDetail.getOrderDetailPrice());
                        userRepo.save(creator);
                    }
                    return CreateOrderDetailResponse.builder()
                            .status("Create order detail successful")
                            .build();
                } else {
                    return CreateOrderDetailResponse.builder()
                            .status("Cart is empty")
                            .build();
                }

            } else {
                return CreateOrderDetailResponse.builder()
                        .status("User not found")
                        .build();
            }

        } else {
            return CreateOrderDetailResponse.builder()
                    .status("Order not found")
                    .build();
        }
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        var order = orderRepo.findOrderByOrderId(orderId).orElse(null);
        if (order != null) {
            return orderDetailRepo.findOrderDetailByOrder(order);
        } else {
            return null;
        }
    }

    @Override
    public List<OrderDetail> getOrderDetailByUser(int userid) {
        List<OrderDetail> allOrderDetails = getAll();
        return allOrderDetails.stream()
                .filter(orderDetail -> orderDetail.getArtwork().getUser().getUsersID() == userid)
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepo.findAll();
    }
}
