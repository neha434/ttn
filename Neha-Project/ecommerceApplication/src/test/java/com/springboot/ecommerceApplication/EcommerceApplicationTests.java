package com.springboot.ecommerceApplication;

import com.springboot.ecommerceApplication.domain.user.Seller;
import com.springboot.ecommerceApplication.repositories.SellerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceApplicationTests {

	@Autowired
	SellerRepo sellerRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void findSeller(){
		Iterable<Seller> seller =sellerRepo.findAll();
		seller.forEach(seller1 -> System.out.println("===================="+seller1.getEmail()));
	}
	@Test
	public void findSingleSeller(){
		System.out.println(sellerRepo.findById(2).get().getEmail());
	}
}
