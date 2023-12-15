package com.iftm.trabalho03.services;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iftm.trabalho03.models.Imovel;
import com.iftm.trabalho03.models.dtos.ImovelDTO;
import com.iftm.trabalho03.repositories.ImovelRepository;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository repository;

    public ResponseEntity<List<ImovelDTO>> findAll() {
        var dbImovel = repository.findAll();
        if (dbImovel.isEmpty())
            return ResponseEntity.notFound().build();

        var imoveisDTO = dbImovel.stream().map(ImovelDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(imoveisDTO);
    }

    public ResponseEntity<ImovelDTO> findById(ObjectId id) {
        if (id == null)
            return ResponseEntity.badRequest().build();
        var dbUser = repository.findById(id);
        if (dbUser.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ImovelDTO(dbUser.get()));
    }

    public ResponseEntity<ImovelDTO> save(Imovel imovel) {
        if (imovel.getEndereco().isBlank() || imovel.getPreco() <= 0)
            return ResponseEntity.badRequest().build();
        imovel.setId(ObjectId.get());
        return ResponseEntity.ok(new ImovelDTO(repository.save(imovel)));
    }

    public ResponseEntity<ImovelDTO> update(ImovelDTO imovel) {
        if (imovel.getId() == null)
            return ResponseEntity.badRequest().build();
        var objectId = new ObjectId(imovel.getId());
        var dbImovel = repository.findById(objectId);
        if (dbImovel.isEmpty())
            return ResponseEntity.notFound().build();
        var dbImovelObj = dbImovel.get();
        dbImovelObj.setEndereco(imovel.getEndereco());
        dbImovelObj.setArea(imovel.getArea());
        dbImovelObj.setTipoImovel(imovel.getTipoImovel());
        dbImovelObj.setPreco(imovel.getPreco());
        return ResponseEntity.ok(new ImovelDTO(repository.save(dbImovelObj)));
    }

    public ResponseEntity<?> delete(ObjectId id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        repository.deleteById(id);

        var dbImovel = repository.findById(id);
        if (dbImovel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        return ResponseEntity.ok().build();
    }
}
