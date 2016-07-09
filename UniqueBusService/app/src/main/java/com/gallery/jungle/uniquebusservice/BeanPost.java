package com.gallery.jungle.uniquebusservice;

import com.google.gson.annotations.SerializedName;


public class BeanPost {


    @SerializedName("Location")
    private String location;
    @SerializedName("Address")
    private String address;
    @SerializedName("CountryCodeNumber")
    private String countryCodeNumber;
    @SerializedName("MobileNumber")
    private String mobileNumber;
    @SerializedName("AreaCodeNumber")
    private String areaCodeNumber;
    @SerializedName("PhoneNumber")
    private String phoneNumber;

    public BeanPost(String location, String address, String countryCodeNumber, String mobileNumber, String areaCodeNumber, String phoneNumber) {
        this.location = location;
        this.address = address;
        this.countryCodeNumber = countryCodeNumber;
        this.mobileNumber = mobileNumber;
        this.areaCodeNumber = areaCodeNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryCodeNumber() {
        return countryCodeNumber;
    }
    public void setCountryCodeNumber(String countryCodeNumber) {
        this.countryCodeNumber = countryCodeNumber;
    }

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public String getAreaCodeNumber() {return areaCodeNumber;}
    public void setAreaCodeNumber(String areaCodeNumber) {
        this.areaCodeNumber = areaCodeNumber;
    }


    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
