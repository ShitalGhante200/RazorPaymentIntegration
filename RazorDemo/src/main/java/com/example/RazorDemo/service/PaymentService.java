package com.example.RazorDemo.service;

import com.example.RazorDemo.entity.OrderEntity;
import com.example.RazorDemo.repository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private RazorpayClient razorpayClient;

    @Autowired
    private OrderRepository orderRepository;

    // Create Razorpay Order
    public OrderEntity createOrder(double amount) throws Exception {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Convert amount to paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "txn_123456");

        Order razorpayOrder = razorpayClient.orders.create(orderRequest);

        // Save order details in the database
        OrderEntity newOrder = new OrderEntity();
        newOrder.setOrderId(razorpayOrder.get("id"));
        newOrder.setAmount(amount);
        newOrder.setCurrency("INR");
        newOrder.setStatus("CREATED");
        orderRepository.save(newOrder);

        return newOrder;
    }

    // Capture Razorpay Payment
    public String capturePayment(String paymentId, String orderId) throws Exception {
        OrderEntity order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new Exception("Order not found!");
        }

        JSONObject captureRequest = new JSONObject();
        captureRequest.put("amount", order.getAmount() * 100);
        captureRequest.put("currency", "INR");

        Payment payment = razorpayClient.payments.capture(paymentId, captureRequest);

        order.setPaymentId(payment.get("id"));
        order.setStatus("PAID");
        orderRepository.save(order);

        return "Payment Captured Successfully!";
    }

    // Get Payment Status
    public Payment getPaymentStatus(String paymentId) throws Exception {
        return razorpayClient.payments.fetch(paymentId);
    }
}
