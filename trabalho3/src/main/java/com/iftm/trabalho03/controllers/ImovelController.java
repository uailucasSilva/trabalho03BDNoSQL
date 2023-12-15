package com.iftm.trabalho03.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.trabalho03.models.Imovel;
import com.iftm.trabalho03.models.dtos.ImovelDTO;
import com.iftm.trabalho03.services.ImovelService;

@RestController
@RequestMapping("api/v1/imovel")
public class ImovelController {
    @Autowired
    private ImovelService service;

    @GetMapping
    public ResponseEntity<List<ImovelDTO>> findAll() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ImovelDTO> findById(@PathVariable("id") ObjectId id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ImovelDTO> create(@RequestBody Imovel imovel) {
        return service.save(imovel);
    }

    @PutMapping
    public ResponseEntity<ImovelDTO> update(@RequestBody ImovelDTO imovel) {
        return service.update(imovel);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
        return service.delete(id);
    }
}
