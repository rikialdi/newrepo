package com.dibimbing.dibimbing.service.impl;

import com.dibimbing.dibimbing.model.Barang;
import com.dibimbing.dibimbing.service.BarangServiceStatic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ImplStaticBarang implements BarangServiceStatic {
    static List<Barang> listBarang = new ArrayList<>();
    @Override
    public Barang save(Barang obj) {
        Long id = (long) (Math.random() * 50 + 1);
        obj.setId(id);
        listBarang.add(obj);
        return obj;
    }

    @Override
    public Barang update(Barang obj) {
        for(Barang data : listBarang){
            if(obj.getId() == data.getId()){
                Barang update = new Barang();
                update.setNama(obj.getNama());
                update.setId(obj.getId());
                update.setSatuan(obj.getSatuan());
                update.setStok(obj.getStok());
                update.setHarga(obj.getHarga());
                listBarang.remove(data);
                listBarang.add(update);
                return update;
            }
        }
        return null;
    }

    @Override
    public List<Barang> deleted(Long id) {
        for(Barang data : listBarang){
            if(id == data.getId()){
                Barang update = new Barang();
                update.setNama(data.getNama());
                update.setId(data.getId());
                update.setSatuan(data.getSatuan());
                update.setStok(data.getStok());
                update.setHarga(data.getHarga());
                listBarang.remove(data);

                return listBarang;
            }
        }
        return null;
    }

    @Override
    public List<Barang> dataMhs(int row,int page) {
        return listBarang;
    }

    @Override
    public Barang findById(long obj) {
        for(Barang data : listBarang){
            if(obj == data.getId()){
                return data;
            }
        }
        return null;
    } 

}
