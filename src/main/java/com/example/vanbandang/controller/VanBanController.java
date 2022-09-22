package com.example.vanbandang.controller;

import com.example.vanbandang.entity.VanBan;
import com.example.vanbandang.search_engine.SearchVanBanRequest;
import com.example.vanbandang.service.VanBanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class VanBanController {
    @Autowired
    private VanBanServiceImpl vanBanServiceImpl;

    @GetMapping
    public ResponseEntity<Iterable<VanBan>> getAllVanBan() {
        return new ResponseEntity<>(vanBanServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<VanBan> getVanBanById(@RequestParam int id) {
        Optional<VanBan> vanBanOptional = vanBanServiceImpl.findById(id);
        return vanBanOptional.map(vanBan -> new ResponseEntity<>(vanBan, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<VanBan>> search(SearchVanBanRequest search)
    {
        return ResponseEntity.ok(vanBanServiceImpl.search(search));
    }

    @PostMapping
    @Validated
    public ResponseEntity<VanBan> createVanBan(@RequestBody @Valid VanBan vb) {
        return new ResponseEntity<>(vanBanServiceImpl.save(vb), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VanBan> updateVanBan(@PathVariable int id, @RequestBody VanBan vanBan) {
        Optional<VanBan> vanBanOptional = vanBanServiceImpl.findById(id);
        return vanBanOptional.map(vanBan1 -> {
            vanBan.setId(vanBan1.getId());
            return new ResponseEntity<>(vanBanServiceImpl.save(vanBan), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VanBan> deleteVanBan(@PathVariable int id) {
        Optional<VanBan> vanBanOptional = vanBanServiceImpl.findById(id);
        return vanBanOptional.map(vanBan -> {
            vanBanServiceImpl.delete(id);
            return new ResponseEntity<>(vanBan, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
