package com.dibimbing.dibimbing.sp.service;


import com.dibimbing.dibimbing.sp.model.BarangMybatis;

import java.util.List;
import java.util.Map;


public interface BarangServiceMybatis {

    BarangMybatis selectBlog(int rqid);

    List<BarangMybatis> selectList(String rqnama);

    void insertProcedure(Double rqharga, String rqnama, String rqsatuan, int rqstok, int resid);

    void updateProcedure(Double rqharga, String rqnama, String rqsatuan, int rqstok, int resid);

    void deleteProcedure(int resid);

    Map updatebarangoutwitheror(Double rqharga, String rqnama, String rqsatuan, int rqstok, int resid);

    Map savebarangoutwitheror(Double rqharga, String rqnama, String rqsatuan, int rqstok, Integer resid);


//    use xml
   public Map updateProcedureXML(BarangMybatis item);
    List<BarangMybatis> listBarangXML(BarangMybatis item);
    BarangMybatis getByIdBarangXML(Integer id);

    public Map testPS(BarangMybatis item);


}
