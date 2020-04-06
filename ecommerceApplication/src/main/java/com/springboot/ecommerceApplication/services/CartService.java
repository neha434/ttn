package com.springboot.ecommerceApplication.services;

import com.springboot.ecommerceApplication.domain.order.Cart;
import com.springboot.ecommerceApplication.domain.product.Product;
import com.springboot.ecommerceApplication.dto.CartDto;
import com.springboot.ecommerceApplication.dto.ProductDto;
import com.springboot.ecommerceApplication.repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
public class CartService {
    @Autowired
    CartRepo cartRepository;

    public List<CartDto> getCartProduct() {
        Iterable<Cart> cartList = cartRepository.findAll();
        List<CartDto> cartDtoList = new ArrayList<>();
        cartList.forEach(carts -> cartDtoList.add(new CartDto(carts.getId(), carts.getQuantity(),
                carts.Wishlist(), carts.getCustomer().getId(),carts.getProductVariation().getId())));

    }

}
