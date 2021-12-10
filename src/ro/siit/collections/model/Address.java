package ro.siit.collections.model;

import java.util.Objects;

public class Address {

    private String street;
    private String number;
    private String city;
    private String county;
    private String country;

    public Address(String street, String number, String city, String county) {
        this(street, number, city, county, "RO");
    }

    public Address(String street, String number, String city, String county, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.county = county;
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

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.toString().equals(address.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }

}
