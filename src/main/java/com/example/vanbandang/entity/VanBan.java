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
/*
{
    "soHieu":"37-QĐ/TW",
    "trichYeu":"Về những điều đảng viên không được làm",
    "loaiVanBan":"Quy định",
    "linhVuc":"Công tác xây dựng, chỉnh đốn đảng",
    "ngayBanHanh":"2021-10-25",
    "ngayHieuLuc":"2021-10-25",
    "coQuanBanHanh":"Ban Chấp Hành Trung Ương",
    "nguoiKy":"Nguyễn Phú Trọng"
}
 */