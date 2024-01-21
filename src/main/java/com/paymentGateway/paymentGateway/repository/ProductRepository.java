package com.paymentGateway.paymentGateway.repository;

import com.paymentGateway.paymentGateway.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product  , Long>
{
}
