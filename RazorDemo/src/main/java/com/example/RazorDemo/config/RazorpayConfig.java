package com.example.RazorDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razorpay.RazorpayClient;

@Configuration
public class RazorpayConfig {

    private static final String RAZORPAY_KEY_ID = "rzp_test_9wVPDFvK2kqYYW";  
    private static final String RAZORPAY_KEY_SECRET = "YIOyg7W7o68MW4fn60cTdfk6"; 
    
    @Bean
    public RazorpayClient razorpayClient() throws Exception {
        return new RazorpayClient(RAZORPAY_KEY_ID, RAZORPAY_KEY_SECRET);
    }
}
