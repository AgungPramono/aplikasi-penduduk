/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.sensus.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 *
 * @author agung
 */

@Data
@Entity
public class Penduduk {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(unique = true)
    @NotNull
    @NotEmpty
    @Size(min = 36,max = 36)
    private String nik;

    @Column
    @NotNull
    @NotEmpty
    @Size(min = 36,max = 36)
    private String nama;

    @Column
    @NotNull
    @NotEmpty
    private LocalDateTime tanggalLahir;

    @NotNull
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "id_pekerjaan")
    private Pekerjaan pekerjaan;

    @NotNull
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "id_agama")
    private Agama agama;

    @NotNull
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "id_pendidikan")
    private Pendidikan pendidikan;

    @NotNull
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "id_golongan_darah")
    private GolonganDarah golonganDarah;

    
}
