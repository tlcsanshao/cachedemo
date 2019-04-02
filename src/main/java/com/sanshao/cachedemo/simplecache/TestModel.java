package com.sanshao.cachedemo.simplecache;

public class TestModel {

    String name;
    String address;

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
        return "TestModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public TestModel() {
    }

    public TestModel(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
