package com.springboot.ecommerceApplication.domain.product;

import com.springboot.ecommerceApplication.domain.user.Customer;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_REVIEW")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class ProductReview extends Product {

    private String review;

    private Double rating;      //Double

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_USER_ID",nullable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
