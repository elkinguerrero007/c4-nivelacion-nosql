package com.unab.c4nivelacionnosql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.c4nivelacionnosql.Collection.Personas;

public interface IPersonasService {

	public List<Personas> all();
    
    public Optional<Personas> findById(String id);
    
    public Personas save(Personas personas);
    
    public void delete(String id);
}
