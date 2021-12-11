package ro.siit.collections.model;

import java.util.Objects;

public class Address {

    private String street;
    private String number;
    private String city;
    private String county;
    private String country;
    private String postalCode;

    public Address(String street, String number, String city, String county, String postalCode) {
        this(street, number, city, county, postalCode, "Romania");
    }

    public Address(String street, String number, String city, String county, String postalCode, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.getPostalCode().equals(address.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPostalCode());
    }

}
