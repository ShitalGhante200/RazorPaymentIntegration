package com.example.RazorDemo.controller;

import java.util.Map;

import com.example.RazorDemo.entity.OrderEntity;
import com.razorpay.Order;
import com.razorpay.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.RazorDemo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create Order API
    @PostMapping(value = "/createOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEntity createOrder(@RequestBody Map<String, Object> data) throws Exception {
        double amount = Double.parseDouble(data.get("amount").toString());
        return paymentService.createOrder(amount);
    }

    // Capture Payment API
    @PostMapping(value = "/capture", produces = MediaType.APPLICATION_JSON_VALUE)
    public String capturePayment(@RequestBody Map<String, String> data) throws Exception {
        return paymentService.capturePayment(data.get("paymentId"), data.get("orderId"));
    }

    // Get Payment Status API
    @GetMapping(value = "/status/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment getPaymentStatus(@PathVariable String paymentId) throws Exception {
        return paymentService.getPaymentStatus(paymentId);
    }
}
