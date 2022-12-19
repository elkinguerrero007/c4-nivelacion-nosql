package com.unab.c4nivelacionnosql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.c4nivelacionnosql.Collection.Usuarios;
import com.unab.c4nivelacionnosql.IRepository.IUsuariosRepository;
import com.unab.c4nivelacionnosql.IService.IUsuariosService;

@Service
public class UsuariosService  implements IUsuariosService{

	@Autowired
	private IUsuariosRepository repository;

	@Override
	public List<Usuarios> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Usuarios> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Usuarios save(Usuarios usuarios) {
		return repository.save(usuarios);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}	
	
}
