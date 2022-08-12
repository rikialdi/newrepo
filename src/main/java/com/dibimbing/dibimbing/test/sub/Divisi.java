package com.dibimbing.dibimbing.test.sub;

import com.dibimbing.dibimbing.test.Karyawan;

public class Divisi extends Karyawan {

    @Override
    public String masukKerja(){
        System.out.println(super.masukKerja());
        return "Divisi HR Masuk kerja 3 kali seminggu";
    }
    public static void main(String[] args) {
        Divisi obj = new Divisi();
        System.out.println(obj.masukKerja());
    }
}
