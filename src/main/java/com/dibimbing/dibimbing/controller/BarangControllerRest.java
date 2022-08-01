package com.dibimbing.dibimbing.controller;

import com.dibimbing.dibimbing.model.Barang;
import com.dibimbing.dibimbing.service.BarangService;
import com.dibimbing.dibimbing.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/barang")
public class BarangControllerRest {

    @Autowired
    public BarangService barangService;

    @PostMapping("/save")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> save(@Valid @RequestBody Barang objModel) {
        Map obj = barangService.insert(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    /*
    insert
    update
    delete
    list
    get by id
     */

    @PutMapping("/update")
    public ResponseEntity<Map> update(@RequestBody Barang objModel) {
        Map map = barangService.update(objModel);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {
        Map map = barangService.delete(id);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map> listByBama(
            @RequestParam() Integer page,
            @RequestParam() Integer size) {
        Map list = barangService.getAll(size, page);
        return new ResponseEntity<Map>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
