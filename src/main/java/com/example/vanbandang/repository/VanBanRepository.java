package com.example.vanbandang.repository;

import com.example.vanbandang.entity.VanBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VanBanRepository extends CrudRepository<VanBan, Integer> {
    Optional findById(int id);
    @Query("select v from VanBan v " +
            "where lower(v.soHieu) like %:soHieu% " +
            "and lower(v.loaiVanBan) like %:loaiVanBan% " +
            "and lower(v.linhVuc) like %:linhVuc% ")
    List<VanBan> getVanBan(String soHieu, String loaiVanBan, String linhVuc);
}
