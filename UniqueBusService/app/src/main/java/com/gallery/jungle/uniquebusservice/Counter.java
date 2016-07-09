package com.gallery.jungle.uniquebusservice;

import com.google.gson.annotations.SerializedName;


public class Counter {

    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
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

    public Counter(int id,String name,String location, String address, String countryCodeNumber, String mobileNumber, String areaCodeNumber, String phoneNumber) {
        this.id=id;
        this.name=name;
        this.location = location;
        this.address = address;
        this.countryCodeNumber = countryCodeNumber;
        this.mobileNumber = mobileNumber;
        this.areaCodeNumber = areaCodeNumber;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
