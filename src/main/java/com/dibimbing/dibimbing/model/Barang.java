package com.dibimbing.dibimbing.model;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
@Entity
@Table(name = "barang")
@Where(clause = "deleted_date is null")
public class Barang  extends  AbstractDate implements Serializable {
    //GenerationType.AUTO : nextvall all tabel sequense
    // GenerationType.IDENTITY : nextvall per tabel sequense
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nama is required.")
    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Range(min=1, max=7,message="ass")
    @Column(name = "stok", nullable = false, length = 10)
    private int stok;

    @Column(name = "satuan", nullable = false, length = 45)
    private String satuan;

    @Column(name = "harga", nullable = false, length = 11)
    private Double harga;

    // wajib
    @ManyToOne(targetEntity = Supplier.class, cascade = CascadeType.ALL)
    private Supplier supplier;//ok supplier_id
}

