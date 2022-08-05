package com.dibimbing.dibimbing.service.impl;

import com.dibimbing.dibimbing.model.Barang;
import com.dibimbing.dibimbing.repository.BarangRepository;
import com.dibimbing.dibimbing.service.BarangService;
import com.dibimbing.dibimbing.utils.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BarangImpl implements BarangService {

    public static final Logger log = LoggerFactory.getLogger(BarangImpl.class);
    @Autowired
    public BarangRepository barangRepository;

    @Autowired
    public TemplateResponse templateResponse;

    @Override
    public Map insert(Barang barang) {
        try {
            //lakukan validasi nama
            if (templateResponse.chekNull(barang.getNama())) {
                return templateResponse.templateEror("Nama is Requiered");
            }

            if (templateResponse.chekNull(barang.getHarga())) {
                return templateResponse.templateEror("Harga is requiered");
            }
            Barang barangObj =   barangRepository.save(barang);
//            Map map = new HashMap();
//            map.put("data",barangObj );
//            map.put("messge","sukses");
//            map.put("code","200");
            log.info("{}","Sukses");
            return templateResponse.templateSukses(barangObj);
        }catch (Exception e){
//            Map map = new HashMap();
//            map.put("messge",e);
//            map.put("code","404");
            log.info("{}","Eror:"+e);
            return templateResponse.templateEror(e);
        }
    }

    /*
    "data":"data",
    "messge:" :"sukses",
    "statuscode" "200"
     */
    @Override
    public Map getAll(int size, int page) {
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Barang> list = barangRepository.getAllData(show_data);
            System.out.println("chek data saya +"+list.getContent());
            return templateResponse.templateSukses(list);
        } catch (Exception e) {
            log.error("ada eror di method getAll:" + e);
            return templateResponse.templateEror(e);
        }
    }


    @Override
    public Map update(Barang barangReq) {
        try {

            if (templateResponse.chekNull(barangReq.getId())) {
                return templateResponse.templateEror("Id Barang is required");
            }
            Barang chekIdBarang = barangRepository.getbyID(barangReq.getId());
            if (templateResponse.chekNull(chekIdBarang)) {
                return templateResponse.templateEror("Id Barang Not found");
            }

            chekIdBarang.setNama(barangReq.getNama());
            chekIdBarang.setHarga(barangReq.getHarga());
            chekIdBarang.setStok(barangReq.getStok());
            chekIdBarang.setSatuan(barangReq.getSatuan());
            Barang dosave = barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses(dosave);
        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map delete(Long barang) {
        try {
            if (templateResponse.chekNull(barang)) {
                return templateResponse.templateEror("Id Barang is required");
            }

            Barang chekIdBarang = barangRepository.getbyID(barang);
            if (templateResponse.chekNull(chekIdBarang)) {
                return templateResponse.templateEror("Id Barang Not found");
            }

//            chekIdBarang.setDeleted_date(new Date());//
            barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses("sukses deleted");

        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }
    }
}
