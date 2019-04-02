package com.sanshao.cachedemo.ehcache;

public class ETestModel {
    String name;
    String address;

    public ETestModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ETestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ETestModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
