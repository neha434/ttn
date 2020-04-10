package com.springboot.ecommerceApplication.repositories;

import com.springboot.ecommerceApplication.domain.user.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepo extends CrudRepository<Seller,Integer> {
    Seller findByEmail(String string);
}
