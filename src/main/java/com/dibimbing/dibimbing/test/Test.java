package com.dibimbing.dibimbing.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.dibimbing.dibimbing.test.Karyawan;
import java.util.Date;


public class Test {
    public static void main(String[] args) {
      Karyawan obj = new Karyawan();
    }

//    public static void main(String[] args) {
//        System.out.println(countPointKaryawan(9));
//        System.out.println(countPointKaryawan(30));
//        System.out.println(countPointKaryawan(49));
//        System.out.println(countPointKaryawan(90));
//        System.out.println(countPointKaryawan(100));
//    }
    public static String countPointKaryawan(int point) {
        if (point >= 1 && point < 10) {
          return "Bonus gaji 10%";
        } else if (point < 30) {
            return "Bonus gaji 30%";
        } else if (point < 50) {
            return "Bonus gaji 50%";
        } else if (point < 70) {
            return "Bonus gaji 70%";
        } else if (point <= 90) {
            return "Bonus gaji 90%";
        } else if (point >= 95 && point < 100) {
            return "Bonus gaji 100%";
        } else {
            return "masukkan nilai antara 1 sd 100";
        }
    }


    public static int saveKaryawan(String nama, int umur, Date dob, String nik) {
        System.out.println("Sukses " + (int) (Math.random() * 90 + 1));
        return (int) (Math.random() * 90 + 1);
    }

    ;
}
