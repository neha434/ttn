package com.springboot.ecommerceApplication.domain.product;

import com.springboot.ecommerceApplication.domain.Role;
import com.springboot.ecommerceApplication.domain.user.Seller;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotNull
    @Size(max = 50)
    private String name;

//    @NotNull
    private String description;

    private boolean isCancellable;
    private boolean isReturnable;

    @Size(max = 25)
//    @NotNull
    private String brand;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category productCategory;

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.MERGE)
    private List<ProductVariation> productVariationList;

    public List<ProductVariation> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariation> productVariationList) {
        this.productVariationList = productVariationList;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductReview> productReviewList;

    @ManyToOne
    @JoinColumn(name = "seller_user_id")
    private Seller seller;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        isReturnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setCategory(Category watches) {
    }

    public List<ProductReview> getProductReviewsList() {
        return productReviewList;
    }

    public void setProductReviewsList(List<ProductReview> productReviewsList) {
        this.productReviewList = productReviewsList;
    }
}
