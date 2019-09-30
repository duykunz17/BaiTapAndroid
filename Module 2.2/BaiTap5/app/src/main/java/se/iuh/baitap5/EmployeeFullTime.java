package se.iuh.baitap5;

public class EmployeeFullTime extends Employee {

    @Override
    public double TinhLuong() {
        return 500;
    }
    public String toString() {
        return super.toString() + " --> Full time = " + TinhLuong();
    }
}
