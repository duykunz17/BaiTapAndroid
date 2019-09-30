package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

public class Human  {
    private  String name;
    private  String national;
    private String price;

    public Human(String name, String national, String price) {
        this.name = name;
        this.national = national;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
