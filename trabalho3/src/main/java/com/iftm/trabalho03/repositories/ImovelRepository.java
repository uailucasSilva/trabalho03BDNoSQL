package com.iftm.trabalho03.repositories;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.iftm.trabalho03.models.Imovel;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ImovelRepository extends MongoRepository<Imovel, ObjectId> {
}
