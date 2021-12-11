package ro.siit.collections.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hobby implements Comparable<Hobby> {

    private String name;
    public int frequency;
    public List<Address> adresaList = new ArrayList<>();

    public Hobby() {
    }

    public Hobby(String name, int frequency, List<Address> adresaList) {
        this.name = name;
        this.frequency = frequency;
        this.adresaList = adresaList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<Address> getAdresaList() {
        return adresaList;
    }

    public void setAdresaList(List<Address> adresaList) {
        this.adresaList = adresaList;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", adresaList=" + adresaList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return getName().equals(hobby.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Hobby o) {
        return this.getName().compareTo(o.getName());
    }

}
