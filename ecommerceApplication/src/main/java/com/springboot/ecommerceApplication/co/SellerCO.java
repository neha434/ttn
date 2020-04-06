package com.springboot.ecommerceApplication.co;

import javax.validation.constraints.NotEmpty;

public class SellerCO extends UserCO {

    @NotEmpty
    private String gst;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String companyContact;

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