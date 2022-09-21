package com.example.vanbandang.service;

import com.example.vanbandang.entity.VanBan;
import com.example.vanbandang.repository.VanBanRepository;
import com.example.vanbandang.search_engine.SearchVanBanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VanBanServiceImpl implements VanBanService {
    @Autowired
    private VanBanRepository vanBanRepository;

    @Override
    public Iterable<VanBan> findAll() {
        return vanBanRepository.findAll();
    }

    @Override
    public List<VanBan> search(SearchVanBanRequest search) {
        return vanBanRepository.getVanBan(search.getSoHieu(),
                search.getLoaiVanBan(), search.getLinhVuc());
    }

    @Override
    public Optional findById(int id) {
        return vanBanRepository.findById(id);
    }

    @Override
    public VanBan save(VanBan vb) {
        return vanBanRepository.save(vb);
    }

    @Override
    public void delete(int id) {
        vanBanRepository.deleteById(id);
    }
}
