package assignment1;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable, Cloneable{
    private String town;
    private String street;
    private String post_code;
    private int house_number;

    public Address(String town, String street, String post_code, int house_number) {
        this.town = town;
        this.street = street;
        this.post_code = post_code;
        this.house_number = house_number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return house_number == address.house_number && Objects.equals(town, address.town) && Objects.equals(street, address.street) && Objects.equals(post_code, address.post_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, street, post_code, house_number);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
