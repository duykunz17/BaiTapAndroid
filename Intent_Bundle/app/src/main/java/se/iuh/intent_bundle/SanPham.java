package se.iuh.intent_bundle;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int maSP;
    private String tenSP;
    private double donGia;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return this.maSP + "-" + this.tenSP + "-" + this.donGia;
    }
}
