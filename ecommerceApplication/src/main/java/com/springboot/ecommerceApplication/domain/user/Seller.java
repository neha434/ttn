package com.springboot.ecommerceApplication.domain.user;

import com.springboot.ecommerceApplication.domain.product.Product;

import javax.persistence.*;
import java.util.List;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SELLERS")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Seller extends User {
    private String gst;
    private String companyContact;
    private String companyName;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Product> productsList;

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
