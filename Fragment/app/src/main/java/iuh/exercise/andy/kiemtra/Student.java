package iuh.exercise.andy.kiemtra;

import java.io.Serializable;

public class Student implements Serializable {
    private String name,email,address;
    private int year;

    public Student(String name, String email, String address, int year) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
