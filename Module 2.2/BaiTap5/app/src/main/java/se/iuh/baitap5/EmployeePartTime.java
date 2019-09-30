package se.iuh.baitap5;

public class EmployeePartTime extends Employee {

    @Override
    public double TinhLuong() {
        return 150;
    }

    public String toString() {
        return super.toString() + " --> Part time = " + TinhLuong();
    }
}
