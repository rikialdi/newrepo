package com.dibimbing.dibimbing.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
public class ReqBarang {

    private Long id;

    @NotEmpty(message = "password is required.")
    private String nama;


    private int stok;


    private String satuan;


    private Double harga;
}
