package com.example.vanbandang.service;


import com.example.vanbandang.entity.VanBan;
import com.example.vanbandang.search_engine.SearchVanBanRequest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
public interface VanBanService {
    Iterable<VanBan> findAll();
    List<VanBan> search(SearchVanBanRequest search);
    Optional findById(int id);
    VanBan save(VanBan vb);
    void delete(int id);
}
