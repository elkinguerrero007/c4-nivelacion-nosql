package com.unab.c4nivelacionnosql.IRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.c4nivelacionnosql.Collection.Usuarios;

public interface IUsuariosRepository extends MongoRepository<Usuarios, String>{

}
