package com.springboot.ecommerceApplication.domain.product;

import com.springboot.ecommerceApplication.domain.order.Cart;
import com.springboot.ecommerceApplication.domain.order.OrderProduct;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PRODUCT_VARIATION")
public class ProductVariation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer  quantityAvailable;

    @NotNull
    private Integer price;
    @Size(max = 100)
    private String primaryImageName;
    private String metadata;;

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<Cart> cartsList;

    public List<Cart> getCartsList() {
        return cartsList;
    }

    public void setCartsList(List<Cart> cartsList) {
        this.cartsList = cartsList;
    }

    @OneToMany(mappedBy = "productVariation",cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductsList;

    public List<OrderProduct> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProduct> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
