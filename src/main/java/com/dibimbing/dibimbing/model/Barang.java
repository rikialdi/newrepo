package com.dibimbing.dibimbing.model;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Entity
@Table(name = "barang")
@Where(clause = "deleted_date is null")
public class Barang implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "nama is required.")
    @Column(name = "nama", nullable = true, length = 45)
    private String nama;


    @Range(min=1, max=6,message="ass")
    @Column(name = "stok", nullable = false, length = 6)
    private int stok;

    @Column(name = "satuan",  length = 45)
    private String satuan;

    @Column(name = "harga",  length = 11)
    private Double harga;
}
