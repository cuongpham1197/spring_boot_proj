package com.example.vanbandang.search_engine;

import lombok.Data;
@Data
public class SearchVanBanRequest {
    private String soHieu;
    private String loaiVanBan;
    private String linhVuc;
    public String getSoHieu() {
        return soHieu.toLowerCase();
    }
    public String getLoaiVanBan() {
        return loaiVanBan.toLowerCase();
    }
    public String getLinhVuc() {
        return linhVuc.toLowerCase();
    }

}
