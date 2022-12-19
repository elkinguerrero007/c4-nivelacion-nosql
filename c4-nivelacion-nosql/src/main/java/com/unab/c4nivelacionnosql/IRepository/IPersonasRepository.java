package com.unab.c4nivelacionnosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.c4nivelacionnosql.Collection.Personas;

public interface IPersonasRepository extends MongoRepository<Personas, String>{

}
