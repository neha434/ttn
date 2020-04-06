package com.springboot.ecommerceApplication.dto;

import javax.validation.constraints.NotEmpty;

public class SellerDto extends UserDto {
    @NotEmpty
    private String gst;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String companyContact;



    public SellerDto() {

    }

    public SellerDto(Integer id, String email, String firstName, String middleName, String lastName, String companyContact, String companyName, String gst) {
        this.setId(id);
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setCompanyContact(companyContact);
        this.setCompanyName(companyName);
        this.setGst(gst);
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

   }