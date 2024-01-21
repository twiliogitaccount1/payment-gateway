package com.paymentGateway.paymentGateway.controller;

import com.paymentGateway.paymentGateway.entity.Product;
import com.paymentGateway.paymentGateway.repository.ProductRepository;
import com.paymentGateway.paymentGateway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController
{
    @Value("${stripe.api.key}")
    private  String stripeApiKey ;


    @Autowired
    private ProductRepository productRepository ;

   @Autowired
   private PaymentService paymentService ;

  // http://localhost:8080/payments/initiate?productId=1

   @PostMapping("/initiate")
   public ResponseEntity<String> initiatePayment(@RequestParam Long productId)
   {
       Product product = productRepository.findById(productId).get();

       String paymentIntentId = paymentService.createPaymentIntent((product.getPrice()));

       return new ResponseEntity<>(paymentIntentId , HttpStatus.OK);
   }










}
