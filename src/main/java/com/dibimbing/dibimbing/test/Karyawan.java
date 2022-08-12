package com.dibimbing.dibimbing.test;

import java.util.Date;

public class Karyawan {
    private Long id;
    public int umur;
    public String nik;
    public  Date dob;

    public String masukKerja(){
        return "Karyawan Masuk Kerja 5 hari seminggu";
    }

    private Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
