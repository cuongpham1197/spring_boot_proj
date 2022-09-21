package com.example.vanbandang.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Van_ban_Dang", uniqueConstraints = {@UniqueConstraint(columnNames = {"soHieu"})})
public class VanBan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String soHieu;

    @Column(nullable = false)
    private String trichYeu;

    @Column(nullable = false)
    private String loaiVanBan;

    @Column(nullable = false)
    private String linhVuc;

    @Column(nullable = false)
    private LocalDate ngayBanHanh;

    @Column(nullable = false)
    private LocalDate ngayHieuLuc;

    @Column(nullable = false)
    private String coQuanBanHanh;

    @Column(nullable = false)
    private String nguoiKy;

}
